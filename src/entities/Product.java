package entities;

import java.util.Random;

public class Product {
    Long id;

    @Override
    public String toString () {
        return "Product " + "id=" + id + ", name=" + name  + ", category=" + category + ", price=" + price ;
    }

    String name;
    Category category;
    Double price;

    public Product ( String name, Category category, Double price ) {
        this.id = generateRandomId();
        this.name = name;
        this.category = category;
        this.price = price;
    }
    private Long generateRandomId() {
        Random random = new Random();
        return (long) (random.nextInt(101 - 100) + 100);
    }

    public Category getCategory () {
        return category;
    }

    public Double getPrice () {
        return price;
    }

    public Long getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public void setPrice ( Double price ) {
        this.price = price;
    }
}
