package com.designPattens.prototypePatten;

import org.junit.Test;

/*
 测试
 */
public class PrototypeTest {

    /*
    只是改变了引用，并没有新的对象创建
     */
    @Test
    public void test() {
        StudentPrototype studentPrototype1 = new StudentPrototype();
        studentPrototype1.setAge(11);
        StudentPrototype studentPrototype2 = studentPrototype1;
        studentPrototype2.setAge(12);
        System.out.println(studentPrototype1 == studentPrototype2);
        System.out.println(studentPrototype1.getAge());
        System.out.println(studentPrototype2.getAge());
    }

    /*
    通过clone() 才是真正的对象复制，克隆方法复制的对象完全是独立的对象
    Object的clone（）是本地方法，直接操作内存中的二进制流特别是复制大对象时，性能比较明显
     */
    @Test
    public void testClone() {
        StudentPrototype studentPrototype1 = new StudentPrototype();
        studentPrototype1.setAge(11);
        StudentPrototype studentPrototype2 = (StudentPrototype) studentPrototype1.clone();
        studentPrototype2.setAge(12);
        System.out.println(studentPrototype1 == studentPrototype2);
        System.out.println(studentPrototype1.getAge());
        System.out.println(studentPrototype2.getAge());
    }

    /*
    浅拷贝：只拷贝当前的对象（如果对象中属性为其它对象时，该属性相当于只改变了引用就会产生数据不一致的问题）
    深拷贝：基于浅拷贝来递归实现具体的每个对象
     */
    @Test
    public void testClone2() {
        StudentPrototype studentPrototype1 = new StudentPrototype();
        studentPrototype1.setAge(11);
        TeacherPrototype teacherPrototype1 = new TeacherPrototype();
        teacherPrototype1.setName("刘老师");
        studentPrototype1.setTeacherPrototype(teacherPrototype1);
        StudentPrototype studentPrototype2 = (StudentPrototype) studentPrototype1.clone();
        studentPrototype2.setAge(12);
        studentPrototype2.getTeacherPrototype().setName("王老师");
        System.out.println(studentPrototype1 == studentPrototype2);
        System.out.println(studentPrototype1.toString());
        System.out.println(studentPrototype2.toString());
    }


    /*
    原形模式应用
     Object的clone（）是本地方法，直接操作内存中的二进制流特别是复制大对象时，性能比较明显
     */
    @Test
    public void testFor() {
        TeacherPrototype teacherPrototype = new TeacherPrototype();
        teacherPrototype.setName("liuliu");

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            StudentPrototype studentPrototype2 = new StudentPrototype();
            studentPrototype2.setAge(i);
            studentPrototype2.getTeacherPrototype().setName("liuliu");
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);

        long start2 = System.currentTimeMillis();
        StudentPrototype studentPrototype3 = null;
        for (int i = 0; i < 1000000; i++) {
            studentPrototype3 = new StudentPrototype();
            studentPrototype3.setAge(i);
            studentPrototype3.getTeacherPrototype().setName("liuliu");
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);

        long start = System.currentTimeMillis();
        StudentPrototype studentPrototype = new StudentPrototype();
        for (int i = 0; i < 1000000; i++) {
            StudentPrototype studentPrototype1 = (StudentPrototype) studentPrototype.clone();
            studentPrototype1.setAge(i);
            studentPrototype1.getTeacherPrototype().setName("liuliu");
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
