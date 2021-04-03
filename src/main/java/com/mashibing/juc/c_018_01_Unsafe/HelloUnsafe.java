package com.mashibing.juc.c_018_01_Unsafe;

//import sun.misc.*;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class HelloUnsafe {
    static class M {
        private M() {
        }

        int i = 0;
    }

    private static Unsafe getUnsafe() throws Throwable {
        Class<?> unsafeClass = Unsafe.class;

        for (Field f : unsafeClass.getDeclaredFields()) {
            if ("theUnsafe".equals(f.getName())) {
                f.setAccessible(true);
                return (Unsafe) f.get(null);
            }
        }
        throw new IllegalAccessException("no declared field: theUnsafe");
    }

    public static void main(String[] args) throws Throwable {
        Unsafe unsafe =getUnsafe();
//        Unsafe unsafe = Unsafe.getUnsafe();
        M m = (M) unsafe.allocateInstance(M.class);
        m.i = 9;
        System.out.println(m.i);
    }
}


