package com.lingheng.object.example;

import java.util.Date;
import java.util.List;
import java.util.Random;


/**
 * Created by lingheng on 2020/4/7.
 */
public class Producer implements Runnable{

    //��Ʒ����
    private final List<Integer> container;
    //��Ʒ�����Ĵ�С
    private final int size=5;

    public Producer( List<Integer> container){
        this.container=container;
    }

    private void produce() throws InterruptedException {
        synchronized (container){
            //�ж������Ƿ�����
            while (container.size()==size){
                System.out.println("�����������ݶ�������");
                container.wait();
            }

            Random random = new Random();
            int num = random.nextInt(10);
            //ģ��1������һ����Ʒ
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"ʱ��"+new Date()+" ������Ʒ��" + num);
            container.add(num);
            //����һ���Ϳ���֪ͨ������������
            container.notifyAll();
        }
    }

    public void run() {

        while (true){
            try {
                produce();
            } catch (InterruptedException e) {
                System.out.println("���������쳣");
                e.printStackTrace();
            }
        }

    }
}
