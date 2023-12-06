import entities.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main ( String[] args ) {
        Product[] products ={
                new Product("peluche1", Category.Baby,50.5),
                new Product("peluche2", Category.Baby,70.5),
                new Product("peluche3", Category.Baby,20.5),
                new Product("peluche4", Category.Baby,100.5),
                new Product("book1", Category.Books,80.8),
                new Product("book2", Category.Books,101.5),
                new Product("book3", Category.Books,115.9),
                new Product("book4", Category.Books,99.99),
                new Product("jacket", Category.Boys,60.6),
                new Product("Hoodie", Category.Boys,80.1),
                new Product("Jeans", Category.Boys,35.5),
                new Product("T-shirt", Category.Boys,20.9),
        };

        //Esercizio 1

        List<Product> majorOfHundred = Arrays.stream(products).filter(product-> product.getCategory() == Category.Books && product.getPrice() > 100).toList();

        for (Product book : majorOfHundred) {
            System.out.println(book.toString());
        }

        System.out.println("*******************************************************************");
        //Esercizio 3

        List<Product> boys = Arrays.stream(products)
                .filter(product -> product.getCategory() == Category.Boys)
                .peek(product -> product.setPrice(product.getPrice() * 0.9))
                .toList();

        for (Product product : boys) {
            System.out.println(product.toString());
        }
        System.out.println("*******************************************************************");
        //Esercizio 2
        List<Product> list1 = new ArrayList<>();
        list1.add(products[1]);
        list1.add(products[2]);
        list1.add(products[6]);

        List<Product> list2 = new ArrayList<>();
        list1.add(products[6]);
        list1.add(products[3]);
        list1.add(products[9]);

        List<Product> list3 = new ArrayList<>();
        list1.add(products[5]);
        list1.add(products[7]);
        list1.add(products[0]);

        Customer[] customers ={
            new Customer("Ilaria", 3),
            new Customer("Luca", 2),
            new Customer("Lucia", 2),
            new Customer("Marco", 1),
            new Customer("Diana", 2),
        };

        Order[] orders={
                new Order(Status.Preparatin, LocalDate.of(2021,1,10),LocalDate.of(2021,1,25),list1,customers[2]),
                new Order(Status.Delivered, LocalDate.of(2021,3,30),LocalDate.of(2021,5,10),list2,customers[1]),
                new Order(Status.Delivered, LocalDate.of(2021,3,25),LocalDate.of(2021,4,1),list2,customers[4]),
                new Order(Status.OnTheWay, LocalDate.of(2021,5,15),LocalDate.of(2021,5,22),list3,customers[3]),
                new Order(Status.Delivered, LocalDate.of(2021,3,25),LocalDate.of(2021,4,1),list1,customers[0]),

        };
        List<Order> baby = Arrays.stream(orders).filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory() == Category.Baby)).toList();

        for (Order order: baby) {
            System.out.println(order.toString());
        }
        System.out.println("*******************************************************************");
        //Esercizio 4
        List<Order> level = Arrays.stream(orders)
                .filter(order -> order.getCustomer().getTier() == 2 && order.getOrderDate().isAfter(LocalDate.of(2021,2,1)) && order.getOrderDate().isBefore(LocalDate.of(2021,4,1))).toList();

        for (Order order : level) {
            System.out.println(order.toString());
        }

    }
}