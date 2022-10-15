package de.dhbwka.java.exercise.threads.buffer;

import java.util.LinkedList;

public class MyBuffer {

    private LinkedList<Integer> values = new LinkedList<>();
    private int maxsize = 3;

    public static void main(String[] args) {
        MyBuffer buf = new MyBuffer(3);

        ProducerThread thread1 = new ProducerThread(buf);
        thread1.start();

        ConsumerThread thread2 = new ConsumerThread(buf);
        thread2.start();
    }

    public MyBuffer(int size) {
        this.maxsize = size;
    }

    public synchronized void put(int v) {
        if (values.size() >= this.maxsize) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        this.values.add(v);
        this.notify();
        System.out.println("Put: " + v);
        System.out.println("Size after put: " + values.size());
    }

    public synchronized int get() {
        int v;
        if (values.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        v = this.values.pop();
        System.out.println("Get: " + v);
        System.out.println("Size after get: " + values.size());
        return v;
    }
}

class ProducerThread extends Thread {

    MyBuffer buf;

    public ProducerThread(MyBuffer b) {
        this.buf = b;
    }

    public void run() {
        int min = 0;
        int max = 1000;
        while (true) {
            this.buf.put(min + (int) (Math.random() * ((max - min) + 1)));
            try {
                sleep(min + (int) (Math.random() * ((max - min) + 1)));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class ConsumerThread extends Thread {

    MyBuffer buf;

    public ConsumerThread(MyBuffer b) {
        this.buf = b;
    }

    public void run() {
        int min = 0;
        int max = 1000;
        while (true) {
            this.buf.get();
            try {
                sleep(min + (int) (Math.random() * ((max - min) + 1)));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}