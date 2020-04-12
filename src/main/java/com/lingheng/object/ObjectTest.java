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
        //������
        Constructor<?>[] constructors=objectClass.getConstructors();
        System.out.println("Object ��Ĺ�������");
        for (Constructor constructor:constructors){
            System.out.print(constructor);
        }
        //����
        Method[] methods=objectClass.getMethods();
        System.out.println("Object ��ķ�����");
        for (Method method:methods){
            System.out.println(method);
        }
        //����
        Field[] fields=objectClass.getFields();
        System.out.println("Object ������ԣ�");
        for (Field field:fields){
            System.out.println(field);
        }

    }

    @Test
    public void hashCodeTest(){
        Object o1=new Object();
        Object o2=new Object();
        Object o3=o1;
        System.out.println("o1��hash�Ĺ�ϣ�룺"+ o1.hashCode());
        System.out.println("o2��hash�Ĺ�ϣ�룺"+ o2.hashCode());
        System.out.println("o3��hash�Ĺ�ϣ�룺"+ o3.hashCode());
    }

    @Test
    public void arrayClone(){
        //�ַ�������
        String[] s=new String[]{"hello","world"};
        System.out.println(s);
        System.out.println(s.clone());

        //��������
        int[] num=new int[]{1,3};
        System.out.println(num);
        System.out.println(num.clone());
    }
}