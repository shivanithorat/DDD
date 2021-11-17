package com.tw.ddd_workshop.domain.items;

public class IPad implements Item{
    private String name;

    public IPad(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Tablet";
    }
}
