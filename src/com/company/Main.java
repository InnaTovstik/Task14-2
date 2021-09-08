package com.company;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        LocalTime start = LocalTime.now();

        Runtime runtime = Runtime.getRuntime();
        int nrOfProcessors = runtime.availableProcessors();
        System.out.println("Number of processors available to the Java Virtual Machine: " + nrOfProcessors);

        int elementsInArray = 2_000;
        int countThreads = nrOfProcessors * 3;
        Threads.goThreads(elementsInArray, countThreads );

        LocalTime finish = LocalTime.now();
        long rez = ChronoUnit.MILLIS.between(start, finish);
        System.out.println("Программа выполнилась за " + rez + " ms");
    }
}