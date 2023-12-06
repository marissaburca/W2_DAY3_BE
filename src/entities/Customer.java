package entities;

import java.util.Random;

public class Customer {
    Long id;
    String name;
    Integer tier;

    public Integer getTier () {
        return tier;
    }

    @Override
    public String toString () {
        return "id=" + id + ", name=" + name + ", tier=" + tier ;
    }

    public String getName () {
        return name;
    }

    public Customer ( String name, Integer tier ) {
        this.id = generateRandomId();
        this.name = name;
        this.tier = tier;
    }
    private Long generateRandomId() {
        Random random = new Random();
        return (long) (random.nextInt(20001 - 10000) + 10000);
    }
}
