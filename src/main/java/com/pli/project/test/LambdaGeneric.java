package com.pli.project.test;

/**
 * Created by lipeng on 2017/2/2.
 */
public class LambdaGeneric {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        A a = () -> {};

        B b = (b1, b2) -> {};
        b.apply("hello", 1);
    //        b.apply(2, 1);    won't pass because the type is wrong.

        C c = (c1, c2) -> {
            System.out.println(c1);
            System.out.println(c2);
        };
        c.apply(1, "hello");
    }

    public interface A {
        public void apply();
    }

    public interface B {
        public void apply(String a, Integer e);
    }

    public interface C<T, V> {
        public void apply(T t, V v);
    }
}
