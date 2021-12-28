package com.example.Properties;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class HunterUnsafeProperties {

    public static void main(String[] args) throws NoSuchFieldException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
    }

}
