package com.company;

import java.util.ArrayList;

public class Threads {

    public static void goThreads(int elements, int countTreads) throws InterruptedException {
        System.out.println("Количество элементов = " + elements + ", количество потоков = " + countTreads);
        int from = 0;
        int to;
        ArrayList<Thread> arrayList = new ArrayList<>();
        int step = elements / countTreads;
        for (int i = 0; i < countTreads; i++) {
            if (i == countTreads - 1) {
                from = i * step;
                to = elements;
            } else {
                from = i * step;
                to = (i * step) + step - 1;
            }
                System.out.println("from = " + from + " to = " + to);
                Thread t = new Thread(new Writer(i * step,
                        ((i * step) + step) - 1,
                        5));
                t.setName("Thread " + i);
                t.start();
                arrayList.add(t);
            }

            for (Thread thread : arrayList)
                thread.join();
        }
    }

