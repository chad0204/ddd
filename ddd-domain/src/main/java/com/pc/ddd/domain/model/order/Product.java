package com.pc.ddd.domain.model.order;

import lombok.Data;

import java.util.Objects;

/**
 * 不变量
 */
@Data
public class Product {
    private final Long id;
    private final String name;
    private final Double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getName().equals(product.getName()) && getPrice().equals(product.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
    }
}
