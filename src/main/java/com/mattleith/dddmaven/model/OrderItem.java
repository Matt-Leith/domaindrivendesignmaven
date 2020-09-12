package com.mattleith.dddmaven.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;
    private Integer weight;

    public OrderItem(Integer weight) {
        this.weight = weight;
    }

    public OrderItem() {
    }

    public Integer getShippingCost() {
        return weight + 3;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", weight=" + weight +
                '}';
    }
}
