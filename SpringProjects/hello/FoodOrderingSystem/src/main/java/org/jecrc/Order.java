package org.jecrc;

import java.util.LinkedHashMap;
import java.util.Map;

public class Order {

    private Customer customer;
    private Map<FoodItem, Integer> selectedItems;

    public Order(Customer customer) {
        this.customer = customer;
        this.selectedItems = new LinkedHashMap<>();
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<FoodItem, Integer> getSelectedItems() {
        return selectedItems;
    }

    public void addItem(FoodItem item, int quantity) {

        if (item != null && quantity > 0) {

            selectedItems.put(
                    item,
                    selectedItems.getOrDefault(item, 0) + quantity
            );

        }
    }
}
