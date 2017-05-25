package com.homelearning;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static com.homelearning.Currency.*;

public class Main {
    public static void main(String[] args) {
        List<Order> ordersList = new ArrayList<Order>(){
            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder("[");
                for (Order order : this) {
                    sb.append(order).append("; \n");
                }
                return sb.delete(sb.length() - 3, sb.length()).append("]").append("\n").toString();
            }
        };


        ordersList.add(new Order(USD, 20, "chocolate", "Roshen",
                new User("Vasya", "Pupkin", "Odessa", 5000)));

        ordersList.add(new Order(USD, 20, "chocolate", "Roshen",
                new User("Olya", "Polyakova", "Kyiv", 70_000)));

        ordersList.add(new Order(USD, 8, "caramel", "Roshen",
                new User("Ivan", "Dulin", "Lviv", 8000)));

        ordersList.add(new Order(USD, 160, "vine", "Ashan",
                new User("Olya", "Molodaya", "Kharkiv", 3000)));

        ordersList.add(new Order(USD, 200, "toy", "Toys house",
                new User("Alina", "Volkova", "Poltava", 10_000)));

        ordersList.add(new Order(USD, 10_000, "phone", "Allo",
                new User("Philip", "Kirkorov", "Minsk", 50_000)));

        System.out.println(ordersList);
        sortDescendingByPrice(ordersList);
        System.out.println(ordersList);

        sortAscendingByPriceThenByCity(ordersList);
        System.out.println(ordersList);

        sortAscendingByOrderNameIdUserCity(ordersList);
        System.out.println(ordersList);
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
}
