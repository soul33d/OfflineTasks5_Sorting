package com.homelearning;

import com.homelearning.task1.Currency;
import com.homelearning.task1.Order;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import static com.homelearning.Task2.*;

public class Task3 {
    public static void main(String[] args) {
        TreeSet<Order> orderSet = new TreeSet<>(Comparator.comparingInt(Order::getPrice)
                .thenComparing(order -> -order.getCurrency().ordinal())
                .thenComparing(order -> order.getUser().getFirstName())
                .thenComparing(order -> order.getUser().getLastName()));
        fillOrdersCollection(orderSet);
        printCollection(orderSet);

        System.out.println("The most expensive order:\n" + orderSet.last() + "\n");

        Iterator<Order> iterator = orderSet.iterator();
        while (iterator.hasNext()){
            Order order = iterator.next();
            if (order.getCurrency() == Currency.USD) iterator.remove();
        }

        printCollection(Currency.USD + " removed from set", orderSet);
    }
}
