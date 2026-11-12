package org.jecrc;

import java.util.List;

public class Restaurant {

    private String restaurantName;
    private String location;
    private List<FoodItem> foodItems;

    public Restaurant(String restaurantName, String location,
                      List<FoodItem> foodItems) {

        this.restaurantName = restaurantName;
        this.location = location;
        this.foodItems = foodItems;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getLocation() {
        return location;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void displayMenu() {

        System.out.println("\nAvailable Food Items:");

        for (int i = 0; i < foodItems.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + foodItems.get(i)
            );
        }

    }
}
