package com.base.compile;

import javax.tools.*;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject.Kind;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Arrays;

public class MyTest {
    //自定义JavaSourceFromString，作为源代码的抽象文件
    static class JavaSourceFromString extends SimpleJavaFileObject {
        final String code;

        public JavaSourceFromString(String name, String code) {
            super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return code;
        }

    }

    //JavaClassFileObject，代表class的文件抽象
    static class JavaClassFileObject extends SimpleJavaFileObject {
        ByteArrayOutputStream outputStream = null;

        public JavaClassFileObject(String className, Kind kind) {
            super(URI.create("string:///" + className.replace('.', '/') + kind.extension), kind);
            outputStream = new ByteArrayOutputStream();
        }

        @Override
        public OutputStream openOutputStream() throws IOException {
            return this.outputStream;
        }

        public byte[] getClassBytes() {
            return outputStream.toByteArray();
        }
    }

    //ClassFileManager，修改JavaFileManager生成class的JavaFileObject的行为，另外返回一个自定义ClassLoader用于返回内存中的字节码对应的类模板
    static class ClassFileManager extends ForwardingJavaFileManager<JavaFileManager> {
        private JavaClassFileObject classFileObject;

        protected ClassFileManager(JavaFileManager fileManager) {
            super(fileManager);
        }

        @Override
        public JavaFileObject getJavaFileForOutput(Location location, String className, Kind kind, FileObject sibling) throws IOException {
            classFileObject = new JavaClassFileObject(className, kind);
            return classFileObject;
        }

        @Override
        public ClassLoader getClassLoader(Location location) {
            return new ClassLoader() {
                @Override
                protected Class<?> findClass(String name) throws ClassNotFoundException {
                    byte[] classBytes = classFileObject.getClassBytes();
                    return super.defineClass(name, classBytes, 0, classBytes.length);
                }
            };
        }
    }

    public static void main(String[] args) {
        String string = "package com.base.compile; \n" + "public class MyPrint implements Printer{ \n" + "@Override \n"
                + "public void print() { \n" + "System.out.println(\"MyPrint...\"); \n" + "} \n" + "}";
//生成源代码的JavaFileObject
        SimpleJavaFileObject fileObject = new JavaSourceFromString("com.base.compile.MyPrint", string);
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//被修改后的JavaFileManager
        JavaFileManager fileManager = new ClassFileManager(compiler.getStandardFileManager(null, null, null));
//执行编译
        CompilationTask task = compiler.getTask(null, fileManager, null, null, null, Arrays.asList(fileObject));
        task.call();
//获得ClassLoader，加载class文件
        ClassLoader classLoader = fileManager.getClassLoader(null);
        try {
            Class<?> printClass = classLoader.loadClass("com.base.compile.MyPrint");
//获得实例
            Printer printer = (Printer) printClass.newInstance();
            printer.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}