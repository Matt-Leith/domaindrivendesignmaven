package com.mattleith.dddmaven.model;

public class StandardItem extends OrderItem {
    public StandardItem(Integer weight) {
        super(weight);
    }

    @Override
    public Integer getShippingCost() {
        return super.getShippingCost() + 5;
    }
}
