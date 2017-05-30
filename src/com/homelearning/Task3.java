package com.homelearning;

import com.homelearning.task1.Order;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import static com.homelearning.Task2.*;

public class Task3 {
    public static void main(String[] args) {
        Set<Order> orderSet = new TreeSet<>(Comparator.comparingInt(Order::getPrice));
        Task2.fillOrdersCollection(orderSet);
        printCollection(orderSet);
    }
}
