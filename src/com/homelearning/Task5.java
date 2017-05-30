package com.homelearning;

import java.util.*;

public class Task5 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        List<Integer> integerArrayListSmaller = new ArrayList<>();
        List<Integer> integerArrayListBigger = new ArrayList<>();
        List<String> stringArrayListSmaller = new ArrayList<>();
        List<String> stringArrayListBigger = new ArrayList<>();

        List<Integer> integerLinkedListSmaller = new LinkedList<>();
        List<Integer> integerLinkedListBigger = new LinkedList<>();
        List<String> stringLinkedListSmaller = new LinkedList<>();
        List<String> stringLinkedListBigger = new LinkedList<>();

        int smalllerSize = 1_000;
        timer.measure( "Adding " + smalllerSize + " Integers to ArrayList : ",
                () -> fillIntegerList (smalllerSize, integerArrayListSmaller));
        int greaterSize = 100_000;
        timer.measure("Adding " + greaterSize + " Integers to ArrayList : ",
                () -> fillIntegerList(greaterSize, integerArrayListBigger));
        timer.measure("Adding " + smalllerSize + " Integers to LinkedList : ",
                () -> fillIntegerList(smalllerSize, integerLinkedListSmaller));
        timer.measure("Adding " + greaterSize + " Integers to LinkedList : ",
                () -> fillIntegerList(greaterSize, integerLinkedListBigger));

        timer.measure("Adding " + smalllerSize + " Strings to ArrayList : ",
                () -> fillStringList(smalllerSize, stringArrayListSmaller));
        timer.measure("Adding " + greaterSize + " Strings to ArrayList : ",
                () -> fillStringList(greaterSize, stringArrayListBigger));
        timer.measure("Adding " + smalllerSize + " Strings to LinkedList :",
                () -> fillStringList(smalllerSize, stringLinkedListSmaller));
        timer.measure("Adding " + greaterSize + " Strings to LinkedList : ",
                () -> fillStringList(greaterSize, stringLinkedListBigger));

        timer.measure("Setting " + smalllerSize + " Integers to middle of ArrayList : ",
                () -> setIntegersAtMiddle (smalllerSize, integerArrayListSmaller));
        timer.measure("Setting " + greaterSize + " Integers to middle of ArrayList : ",
                () -> setIntegersAtMiddle (greaterSize, integerArrayListBigger));
        timer.measure("Setting " + smalllerSize + " Integers to middle of LinkedList : ",
                () -> setIntegersAtMiddle (smalllerSize, integerLinkedListSmaller));
        timer.measure("Setting " + greaterSize + " Integers to middle of LinkedList : ",
                () -> setIntegersAtMiddle (greaterSize, integerLinkedListBigger));

        timer.measure("Getting 100 times from the middle of ArrayList : ",
                () -> getFromTheMiddle(100, integerArrayListSmaller));
        timer.measure("Getting 100 times from the middle of ArrayList : ",
                () -> getFromTheMiddle(100, integerArrayListBigger));
        timer.measure("Getting 100 times from the middle of LinkedList : ",
                () -> getFromTheMiddle(100, integerLinkedListSmaller));
        timer.measure("Getting 100 times from the middle of LinkedList : ",
                () -> getFromTheMiddle(100, integerLinkedListBigger));

        timer.measure("Remove 100 times from the begining of ArrayList : ",
                () -> removeFromTheBegining(100, integerArrayListSmaller));
        timer.measure("Remove 100 times from the begining of ArrayList : ",
                () -> removeFromTheBegining(100, integerArrayListBigger));
        timer.measure("Remove 100 times from the begining of LinkedList : ",
                () -> removeFromTheBegining(100, integerLinkedListSmaller));
        timer.measure("Remove 100 times from the begining of LinkedList : ",
                () -> removeFromTheBegining(100, integerLinkedListBigger));
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
