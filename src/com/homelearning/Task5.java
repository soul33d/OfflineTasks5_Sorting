package com.homelearning;

import java.util.*;

public class Task5 {

    private static Timer timer = new Timer();

    public static void main(String[] args) {
        List<Integer> integerArrayList1000 = new ArrayList<>();
        List<Integer> integerArrayList10_000 = new ArrayList<>();
        List<String> stringArrayList1000 = new ArrayList<>();
        List<String> stringArrayList10_000 = new ArrayList<>();

        List<Integer> integerLinkedList1000 = new LinkedList<>();
        List<Integer> integerLinkedList10_000 = new LinkedList<>();
        List<String> stringLinkedList1000 = new LinkedList<>();
        List<String> stringLinkedList10_000 = new LinkedList<>();

        int smalllerSize = 10_000;
        timer.measure( "Adding 1000 Integers to ArrayList : ",
                () -> fillIntegerList (smalllerSize, integerArrayList1000));
        int greaterSize = 1_000_000;
        timer.measure("Adding 10_000 Integers to ArrayList : ",
                () -> fillIntegerList(greaterSize, integerArrayList10_000));
        timer.measure("Adding 1000 Integers to LinkedList : ",
                () -> fillIntegerList(smalllerSize, integerLinkedList1000));
        timer.measure("Adding 10_000 Integers to LinkedList : ",
                () -> fillIntegerList(greaterSize, integerLinkedList10_000));

        timer.measure("Adding 1000 Strings to ArrayList : ",
                () -> fillStringList(smalllerSize, stringArrayList1000));
        timer.measure("Adding 10_000 Strings to ArrayList : ",
                () -> fillStringList(greaterSize, stringArrayList10_000));
        timer.measure("Adding 1000 Strings to LinkedList :",
                () -> fillStringList(smalllerSize, stringLinkedList1000));
        timer.measure("Adding 10_000 Strings to LinkedList : ",
                () -> fillStringList(greaterSize, stringLinkedList10_000));

        timer.measure("Setting 1000 Integers to middle of ArrayList : ",
                () -> setIntegersAtMiddle (smalllerSize, integerArrayList1000));
        timer.measure("Setting 10_000 Integers to middle of ArrayList : ",
                () -> setIntegersAtMiddle (greaterSize, integerArrayList1000));
        timer.measure("Setting 1000 Integers to middle of LinkedList : ",
                () -> setIntegersAtMiddle (smalllerSize, integerLinkedList1000));
        timer.measure("Setting 10_000 Integers to middle of LinkedList : ",
                () -> setIntegersAtMiddle (greaterSize, integerLinkedList1000));

        timer.measure("Getting 100 times from the middle of ArrayList : ",
                () -> getFromTheMiddle(100, integerArrayList1000));
        timer.measure("Getting 100 times from the middle of ArrayList : ",
                () -> getFromTheMiddle(100, integerArrayList10_000));
        timer.measure("Getting 100 times from the middle of LinkedList : ",
                () -> getFromTheMiddle(100, integerLinkedList1000));
        timer.measure("Getting 100 times from the middle of LinkedList : ",
                () -> getFromTheMiddle(100, integerLinkedList10_000));

        timer.measure("Remove 100 times from the begining of ArrayList : ",
                () -> removeFromTheBegining(100, integerArrayList1000));
        timer.measure("Remove 100 times from the begining of ArrayList : ",
                () -> removeFromTheBegining(100, integerArrayList10_000));
        timer.measure("Remove 100 times from the begining of LinkedList : ",
                () -> removeFromTheBegining(100, integerLinkedList1000));
        timer.measure("Remove 100 times from the begining of LinkedList : ",
                () -> removeFromTheBegining(100, integerLinkedList10_000));
    }

    private static void fillIntegerList(int count, List<Integer> integerList) {
        for (int i = 0; i < count; i++) {
            integerList.add((int) (Math.random()*100));
        }
    }

    private static void fillStringList(int count, List<String> stringList) {
        for (int i = 0; i < count; i++) {
            stringList.add(UUID.randomUUID().toString());
        }
    }

    private static void setIntegersAtMiddle(int count, List<Integer> integerList) {
        for (int i = 0; i < count; i++) {
            integerList.set(integerList.size() / 2, i);
        }
    }

    private static void getFromTheMiddle(int count, List list) {
        for (int i = 0; i < count; i++) {
            list.get(0);
        }
    }

    private static void removeFromTheBegining(int count, List list) {
        for (int i = 0; i < count; i++) {
            list.remove(0);
        }
    }



    private static class Timer{
        private long startTime = 0L;

        void start(){
            startTime = System.currentTimeMillis();
        }

        long stop(){
            return System.currentTimeMillis() - startTime;
        }

        void measure(String message, Action action){
            start();
            action.act();
            System.out.println(message + stop());
        }

        long mesure(Action action){
            start();
            action.act();
            return stop();
        }
    }

    private interface Action{
        void act();
    }
}
