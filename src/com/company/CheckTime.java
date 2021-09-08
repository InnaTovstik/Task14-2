package com.company;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class CheckTime {

    public static void checkTimeProgram (int elementsInArray, int countThreads) throws InterruptedException {
        LocalTime start = LocalTime.now();
        Threads.goThreads(elementsInArray, countThreads );
        LocalTime finish = LocalTime.now();

        long rez = ChronoUnit.MILLIS.between(start, finish);
        System.out.println("Программа выполнилась за " + rez + " ms");

    }
}
