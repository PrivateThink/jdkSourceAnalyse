package com.lingheng.object;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by lingheng on 2020/4/5.
 */
public class ObjectTest {

    @Test
    public void getClassTest(){
        Object object=new Object();
        System.out.println(object.getClass());
        Class<?> objectClass=object.getClass();
        //构造器
        Constructor<?>[] constructors=objectClass.getConstructors();
        System.out.println("Object 类的构造器：");
        for (Constructor constructor:constructors){
            System.out.print(constructor);
        }
        //方法
        Method[] methods=objectClass.getMethods();
        System.out.println("Object 类的方法：");
        for (Method method:methods){
            System.out.println(method);
        }
        //属性
        Field[] fields=objectClass.getFields();
        System.out.println("Object 类的属性：");
        for (Field field:fields){
            System.out.println(field);
        }

    }

    @Test
    public void hashCodeTest(){
        Object o1=new Object();
        Object o2=new Object();
        Object o3=o1;
        System.out.println("o1的hash的哈希码："+ o1.hashCode());
        System.out.println("o2的hash的哈希码："+ o2.hashCode());
        System.out.println("o3的hash的哈希码："+ o3.hashCode());
    }

    @Test
    public void arrayClone(){
        //字符串数组
        String[] s=new String[]{"hello","world"};
        System.out.println(s);
        System.out.println(s.clone());

        //整数数组
        int[] num=new int[]{1,3};
        System.out.println(num);
        System.out.println(num.clone());
    }
}