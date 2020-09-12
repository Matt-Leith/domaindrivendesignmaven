package com.mattleith.dddmaven.model;

public class BulkyItem extends OrderItem {
    public BulkyItem(Integer weight) {
        super(weight);
    }

    @Override
    public Integer getShippingCost() {
        return super.getShippingCost() + 10;
    }
}
