package com.lingheng.object.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/4/7.
 */
public class Main {

    public static void main(String[] args){
        List<Integer> container = new ArrayList<Integer>();
        Thread producer = new Thread(new Producer(container));
        Thread consumer = new Thread(new Consumer(container));
        producer.start();
        consumer.start();
    }
}
