package com.example.gdritzysfinal;

public class OrderItems {
    private String itemName;
    private Double cost;
    private String custom;

    public OrderItems(String itemName, Double cost, String custom){
        this.itemName = itemName;
        this.cost = cost;
        this.custom = custom;
    }

    public String getItemName() {
        return itemName;
    }

    public Double getCost() {
        return cost;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public String toString(){
        return getItemName()+ " " + String.valueOf(getCost()) + " " +  getCustom();
    }
}
