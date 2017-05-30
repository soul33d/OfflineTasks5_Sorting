package com.homelearning;

import com.homelearning.task1.Order;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import static com.homelearning.Task2.fillOrdersCollection;
import static com.homelearning.Task2.printCollection;
import static com.homelearning.task1.Currency.USD;

public class Task3 {
    public static void main(String[] args) {
        TreeSet<Order> orderSet = new TreeSet<>(Comparator.comparingInt(Order::getPrice)
                .thenComparing(order -> -order.getCurrency().ordinal())
                .thenComparing(order -> order.getUser().getFirstName())
                .thenComparing(order -> order.getUser().getLastName()));
        fillOrdersCollection(orderSet);
        printCollection(orderSet);

        System.out.println("Finding Petrov's orders:");
        orderSet.stream().filter(order -> order.getUser().getLastName().equals("Petrov")).forEach(System.out::println);

        System.out.println("\nThe most expensive order:\n" + orderSet.last() + "\n");

        Iterator<Order> iterator = orderSet.iterator();
        while (iterator.hasNext()){
            Order order = iterator.next();
            if (order.getCurrency() == USD) iterator.remove();
        }

        printCollection(USD + " removed from set", orderSet);
    }
}
