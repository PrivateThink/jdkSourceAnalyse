package com.lingheng.object.example;

import java.util.Date;
import java.util.List;
import java.util.Random;


/**
 * Created by lingheng on 2020/4/7.
 */
public class Producer implements Runnable{

    //产品容器
    private final List<Integer> container;
    //产品容器的大小
    private final int size=5;

    public Producer( List<Integer> container){
        this.container=container;
    }

    private void produce() throws InterruptedException {
        synchronized (container){
            //判断容器是否已满
            while (container.size()==size){
                System.out.println("容器已满，暂定生产。");
                container.wait();
            }

            Random random = new Random();
            int num = random.nextInt(10);
            //模拟1秒生产一个产品
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"时间"+new Date()+" 生产产品：" + num);
            container.add(num);
            //生产一个就可以通知消费者消费了
            container.notifyAll();
        }
    }

    public void run() {

        while (true){
            try {
                produce();
            } catch (InterruptedException e) {
                System.out.println("生产机器异常");
                e.printStackTrace();
            }
        }

    }
}
