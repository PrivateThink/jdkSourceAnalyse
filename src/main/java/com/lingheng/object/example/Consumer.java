package com.lingheng.object.example;

import java.util.Date;
import java.util.List;

/**
 * Created by lingheng on 2020/4/7.
 */
public class Consumer implements Runnable{

    //��������
    private final List<Integer> container;

    public Consumer(List<Integer> container){
        this.container=container;
    }

    private void consume() throws InterruptedException {
        synchronized(container){
            while (container.isEmpty()){
                System.out.println("û�п����ѵĲ�Ʒ");
                //�ȴ�
                container.wait();
            }

            //���Ѳ�Ʒ
            Thread.sleep(100);
            Integer num=container.remove(0);
            System.out.println(Thread.currentThread().getName()+"ʱ��"+new Date()+" ���Ѳ�Ʒ��"+num);
            //����һ���Ϳ���֪ͨ������������
            container.notifyAll();
        }
    }

    public void run() {
        while (true){
            try {
                consume();
            } catch (InterruptedException e) {
                System.out.println("���Ѵ���");
                e.printStackTrace();
            }
        }
    }
}
