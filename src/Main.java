import entities.Category;
import entities.Product;
import java.util.Arrays;
import java.util.List;

import java.time.LocalDate;

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
    }
}