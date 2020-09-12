package com.mattleith.dddmaven.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Load {
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
    @Id
    @GeneratedValue
    private Long id;

    protected Load() {
        this.orderItems = new ArrayList<OrderItem>();
    }

    public double getShippingCosts() {
        int shippingCosts = 0;
        for (OrderItem orderItem : orderItems) {
            shippingCosts += orderItem.getShippingCost();
        }
        return shippingCosts;
    }

    public int getNumberOfShippingItems() {
        return orderItems.size();
    }

    public double getAverageShippingCost() {
        return getShippingCosts() / getNumberOfShippingItems();
    }

    public static class Builder {

        private Load load;

        public Builder() {
            this.load = new Load();
        }

        public Builder withBulkyItem(int weight) {
            this.load.add(new BulkyItem(weight));
            return this;
        }

        public Builder withStandardItem(int weight) {
            this.load.add(new StandardItem(weight));
            return this;
        }

        public Builder withLightweightItem(int weight) {
            this.load.add(new LightweightItem(weight));
            return this;
        }

        public Load build() {
            if (load.orderItems.size() == 0) {
                throw new IllegalStateException("...");
            }
            return this.load;
        }
    }

    void add(OrderItem item) {
        this.orderItems.add(item);
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Load{" +
                "orderItems=" + orderItems +
                ", id=" + id +
                '}';
    }
}
