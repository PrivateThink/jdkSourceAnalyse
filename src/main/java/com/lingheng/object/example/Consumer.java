package com.lingheng.object.example;

import java.util.Date;
import java.util.List;

/**
 * Created by lingheng on 2020/4/7.
 */
public class Consumer implements Runnable{

    //消费容器
    private final List<Integer> container;

    public Consumer(List<Integer> container){
        this.container=container;
    }

    private void consume() throws InterruptedException {
        synchronized(container){
            while (container.isEmpty()){
                System.out.println("没有可消费的产品");
                //等待
                container.wait();
            }

            //消费产品
            Thread.sleep(100);
            Integer num=container.remove(0);
            System.out.println(Thread.currentThread().getName()+"时间"+new Date()+" 消费产品："+num);
            //消费一个就可以通知生产者消费了
            container.notifyAll();
        }
    }

    public void run() {
        while (true){
            try {
                consume();
            } catch (InterruptedException e) {
                System.out.println("消费错误");
                e.printStackTrace();
            }
        }
    }
}
