package com.homelearning;

import com.homelearning.task1.*;

import java.util.*;
import java.util.stream.Collectors;

import static com.homelearning.task1.Currency.UAH;
import static com.homelearning.task1.Currency.USD;
import static com.homelearning.task1.Product.*;

public class Task2 {
    public static void main(String[] args) {
        List<Order> ordersList = new ArrayList<>();

        fillOrdersCollection(ordersList);

        printCollection(ordersList);
        sortDescendingByPrice(ordersList);
        printCollection("Descending sort by price.", ordersList);

        sortAscendingByPriceThenByCity(ordersList);
        printCollection("Ascending sort by price and city.", ordersList);

        sortAscendingByOrderNameIdUserCity(ordersList);
        printCollection("Ascending sort by Order name, Order id, user city.", ordersList);

        removeDuplicates(ordersList);
        printCollection("Removing duplicates", ordersList);

        int lowBound = 150;
        ordersList = removeByPriceLowBound(lowBound, ordersList);
        printCollection("Removing orders with price lower then " + lowBound + ".", ordersList);

        List<Order> orderListUAH = filterByCurrency(ordersList, UAH);
        List<Order> orderListUSD = filterByCurrency(ordersList, USD);
        printCollection(UAH + " list", orderListUAH);
        printCollection(USD + " list", orderListUSD);

        Map<String, List<Order>> mapOrdersList = new HashMap<>();
        splitListByUniqueUserCities(ordersList, mapOrdersList);
        mapOrdersList.forEach(Task2::printCollection);
    }

    public static void fillOrdersCollection(Collection<Order> orders) {
        orders.add(new Order(UAH, CHOCOLATE, "Roshen",
                new User(0, "Vasya", "Pupkin", "Odessa", 5000)));

        orders.add(new Order(UAH, CHOCOLATE, "Roshen",
                new User(1, "Olya", "Polyakova", "Kyiv", 70_000)));

        orders.add(new Order(USD, CARAMEL, "Roshen",
                new User(2, "Ivan", "Dulin", "Lviv", 8000)));

        orders.add(new Order(UAH, VINE, "Ashan",
                new User(3, "Olya", "Molodaya", "Kharkiv", 3000)));

        orders.add(new Order(USD, TOY, "Toys house",
                new User(4, "Alina", "Volkova", "Poltava", 10_000)));

        orders.add(new Order(USD, TOY, "Toys house",
                new User(4, "Alina", "Volkova", "Poltava", 10_000)));

        orders.add(new Order(USD, PHONE, "Allo",
                new User(5, "Philip", "Kirkorov", "Minsk", 50_000)));

        orders.add(new Order(USD, PHONE, "Allo",
                new User(5, "Philip", "Kirkorov", "Minsk", 50_000)));

        orders.add(new Order(UAH, CARAMEL, "Allo",
                new User(6, "Eugene", "Petrov", "Chernigov", 1000)));

        orders.add(new Order(UAH, VINE, "Furshet",
                new User(7, "Vitaliy", "Ostapenko", "Khorol", 5_000)));
    }

    private static void sortDescendingByPrice(List<Order> ordersList) {
        ordersList.sort((o1, o2) -> o2.getPrice() - o1.getPrice());
    }

    private static void sortAscendingByPriceThenByCity(List<Order> ordersList) {
        ordersList.sort((o1, o2) -> {
            int priceSortResult = o1.getPrice() - o2.getPrice();
            return priceSortResult == 0 ? o1.getUser().getCity().compareTo
                            (o2.getUser().getCity()) : priceSortResult;
        });
    }

    private static void sortAscendingByOrderNameIdUserCity(List<Order> ordersList) {
        ordersList.sort(Comparator.comparing(Order::getItemName)
                .thenComparing(Comparator.comparing(Order::getId))
                .thenComparing(Comparator.comparing(o -> o.getUser().getCity())));
    }

    private static void removeDuplicates(List<Order> ordersList) {
        Set<Order> set = new HashSet<>(ordersList.size());
        for (int i = 0; i < ordersList.size(); i++) {
            if (!set.add(ordersList.get(i))) {
                ordersList.remove(i);
                i--;
            }
        }
    }

    private static List<Order> removeByPriceLowBound(int lowBound, List<Order> ordersList) {
        return ordersList.stream().filter(order -> order.getPrice() > lowBound).collect(Collectors.toList());
    }

    private static List<Order> filterByCurrency(List<Order> ordersList, com.homelearning.task1.Currency currency) {
        return ordersList.stream().filter(order -> order.getCurrency() == currency).collect(Collectors.toList());
    }

    private static void splitListByUniqueUserCities(List<Order> ordersList, Map<String, List<Order>> mapOrdersList) {
        ordersList.forEach(order -> {
            if (mapOrdersList.get(order.getUser().getCity()) == null){
                List<Order> orderList = new ArrayList<>();
                orderList.add(order);
                mapOrdersList.put(order.getUser().getCity(), orderList);
            } else {
                mapOrdersList.get(order.getUser().getCity()).add(order);
            }
        });
    }

    public static void printCollection(Collection<Order> orderCollection){
        orderCollection.forEach(order -> System.out.println(order + "\n"));
        System.out.println("\n");
    }

    public static void printCollection(String msg, Collection<Order> orderCollection){
        System.out.println(msg + ":");
        printCollection(orderCollection);
    }
}
