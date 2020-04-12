package com.lingheng.object;

/**
 * Created by lingheng on 2020/4/12.
 */
public class ObjectCloneTest {
    public static void main(String [] args) throws CloneNotSupportedException {
        ObjectCloneTest o=new ObjectCloneTest();
        ObjectCloneTest cloneTest= (ObjectCloneTest) o.clone();
        System.out.println(cloneTest);
    }
}
