package com.mattleith.dddmaven.model;

public class LightweightItem extends OrderItem {
    public LightweightItem(Integer weight) {
        super(weight);
    }

    @Override
    public Integer getShippingCost() {
        return super.getShippingCost() - 5;
    }
}
