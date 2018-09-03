package com.imokhonko.sax_products;

public class Product {

    private final String name;
    private final Category category;
    private final String description;
    private final Price price;

    public Product(String name, Category category, String description, Price price) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
