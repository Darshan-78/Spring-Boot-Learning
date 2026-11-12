package org.jecrc;

import java.util.Map;

public class Payment {

    private Order order;

    public Payment(Order order) {
        this.order = order;
    }

    public int calculateTotal() {

        int total = 0;

        for (Map.Entry<FoodItem, Integer> entry :
                order.getSelectedItems().entrySet()) {

            FoodItem item = entry.getKey();
            int quantity = entry.getValue();

            total += item.getPrice() * quantity;
        }

        return total;
    }
}
