package com.designPattens.singletonPatten;

import java.util.ArrayList;
import java.util.List;

/*
  单列模式
 */
public final class Sington {

    /*
    饿汉模式：系统启动加载类时就直接创建该对象
     */
    /*private static Sington sington = new Sington();

    private Sington(){}

    public static Sington getInstance(){
        return sington;
    }*/

    /*
    懒汉模式 : 用于工具类
     synchronized + 双重检测 + volation
    在执行 instance = new Singleton(); 代码时，正常情况下，实例过程这样的：
    给 Singleton 分配内存；
    调用 Singleton 的构造函数来初始化成员变量；
    将 Singleton 对象指向分配的内存空间（执行完这步 singleton 就为非 null 了）。
    如果虚拟机发生了重排序优化，这个时候步骤 3 可能发生在步骤 2 之前。如果初始化线程刚好完成步骤 3，而步骤 2 没有进行时，
    则刚好有另一个线程到了第一次判断，这个时候判断为非 null，并返回对象使用，这个时候实际没有完成其它属性的构造，
    因此使用这个属性就很可能会导致异常。在这里，Synchronized 只能保证可见性、原子性，无法保证执行的顺序。

    这个时候，就体现出 Happens-Before 规则的重要性了。通过字面意思，你可能会误以为是前一个操作发生在后一个操作之前。
    然而真正的意思是，前一个操作的结果可以被后续的操作获取。这条规则规范了编译器对程序的重排序优化。
    我们知道 volatile 关键字可以保证线程间变量的可见性，简单地说就是当线程 A 对变量 X 进行修改后，
    在线程 A 后面执行的其它线程就能看到变量 X 的变动。
    除此之外，volatile 在 JDK1.5 之后还有一个作用就是阻止局部重排序的发生，也就是说，volatile 变量的操作指令都不会被重排序。
    所以使用 volatile 修饰 instance 之后，Double-Check 懒汉单例模式就万无一失了。
     */
    /* private volatile static Sington sington = null; // volatile:禁止指令重排序

    private List<String> list = null;

    private Sington(){
        list = new ArrayList<>();
    }

    public static Sington getInstance(){
        if (null == sington) {
            synchronized(Sington.class){
                if (null == sington) { // 同步锁
                    sington = new Sington();
                }
            }
        }
        return sington;
    }*/

    /*
    懒汉模式 + 内部类
    在饿汉模式中，我们使用了 static 修饰了成员变量 instance，所以该变量会在类初始化的过程中被收集进类构造器即 <clinit> 方法中。
    在多线程场景下，JVM 会保证只有一个线程能执行该类的 <clinit> 方法，其它线程将会被阻塞等待。
    这种方式可以保证内存的可见性、顺序性以及原子性。
    如果我们在 Singleton 类中创建一个内部类来实现成员变量的初始化，则可以避免多线程下重复创建对象的情况发生。
    这种方式，只有在第一次调用 getInstance() 方法时，才会加载 InnerSingleton 类，
    而只有在加载 InnerSingleton 类之后，才会实例化创建对象。
     */
    private List<String> list = null;

    private Sington() {
        list = new ArrayList<>();
    }

    public static final class InnerSington{
        public static Sington sington = new Sington();
    }

    public static Sington getInstance(){
        return InnerSington.sington;
    }
}
