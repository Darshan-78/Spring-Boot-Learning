package org.jecrc;

public class FoodItem {

    private String foodName;
    private int price;

    public FoodItem(String foodName, int price) {
        this.foodName = foodName;
        this.price = price;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return foodName + " - Rs. " + price;
    }
}
