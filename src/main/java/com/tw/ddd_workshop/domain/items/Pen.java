package com.tw.ddd_workshop.domain.items;

public class Pen implements Item{
    private String name;

    public Pen(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Stationary";
    }
}
