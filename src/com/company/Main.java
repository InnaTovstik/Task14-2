package com.company;

public class Main {

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        int nrOfProcessors = runtime.availableProcessors();
        System.out.println("Number of processors available to the Java Virtual Machine: " + nrOfProcessors);

        CheckTime.checkTimeProgram(2_000_000, nrOfProcessors * 3);
        CheckTime.checkTimeProgram(2_000_000, 1);
    }
}