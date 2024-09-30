package com.task.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
public class Product {
    private String name;
    private Set<Product> components;

    public Product(String name) {
        this.name = name;
        this.components = new HashSet<>();
    }

    public boolean addProduct(Product product) {
        // Если пытаемся добавить продукт в самого себя, сразу возвращаем false
        if (product == this) {
            return false;
        }

        // Если продукт уже есть в составе, возвращаем false
        if (containsProduct(product)) {
            return false;
        }

        // Если продукт содержит текущий продукт в своей иерархии, возвращаем false
        if (product.containsProduct(this)) {
            return false;
        }

        components.add(product);
        return true;
    }

    // Проверяем, содержится ли продукт в списке компонентов, включая все подуровни (рекурсивно)
    private boolean containsProduct(Product product) {
        if (this.components.contains(product)) {
            return true;
        }
        for (Product component : this.components) {
            if (component.containsProduct(product)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
