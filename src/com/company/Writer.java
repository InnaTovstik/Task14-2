package com.company;
//С помощью многопоточности заполнить массива строк из 20 млн элементов.
// Если индекс делится на 3 без остатка - записать в ячейку "Fizz",
// если делится на 5 без остатка - "Buzz",
// если делится и на 3 и на 5 - "FizzBuzz".
// Во всех остальных случаях записать в ячейку строковое представление ее индекса (4 -> "4").
// Сравнить время выполнения программы с одним потоком и с несколькими. Количество потоков на ваше усмотрение.

import java.util.ArrayList;

public class Writer implements Runnable {
    int from;
    int to;
    int latency;

    public Writer(int from, int to, int latency) {
        this.from = from;
        this.to = to;
        this.latency = latency;
    }

    @Override
    public void run() {

        ArrayList<String> arrayList = new ArrayList<>();
        String a = "Fizz";
        String b = "Buzz";
        try {
            for (int i = from; i < to; i++) {
                Thread.sleep(latency);
                if ((i % 3) == 0 && (i % 5) == 0) {
                    arrayList.add(a + b);
                    System.out.println("[" + i + "]= " + (a+b));
                } else {
                    if (i % 3 == 0) {
                        arrayList.add(a);
                        System.out.println("[" + i + "]= " + a);
                    } else {
                        if ((i % 5) == 0) {
                            arrayList.add(b);
                            System.out.println("[" + i + "]= " + b);
                        } else {
                            arrayList.add(String.valueOf(i));
                            System.out.println("[" + i + "]= " + i);
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}