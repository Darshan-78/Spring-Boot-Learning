package org.jecrc;

import java.util.Map;
import java.util.Scanner;

public class OrderService {

    private Restaurant restaurant;
    private Order order;
    private Payment payment;

    public OrderService(Restaurant restaurant,
                        Order order,
                        Payment payment) {

        this.restaurant = restaurant;
        this.order = order;
        this.payment = payment;
    }

    public void placeOrder() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("       FOODIE'S HUB");
        System.out.println("================================");

        System.out.println("Restaurant: " +
                restaurant.getRestaurantName());

        System.out.println("Location: " +
                restaurant.getLocation());

        restaurant.displayMenu();

        System.out.println("\nEnter 0 to finish ordering.");

        while (true) {

            System.out.print("\nEnter food item number: ");
            String input = scanner.nextLine();

            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            if (choice == 0) {
                break;
            }

            if (choice < 1 ||
                    choice > restaurant.getFoodItems().size()) {

                System.out.println("Invalid food item selection.");
                continue;
            }

            FoodItem selectedItem =
                    restaurant.getFoodItems().get(choice - 1);

            System.out.print("Enter quantity: ");
            String quantityInput = scanner.nextLine();

            int quantity;

            try {
                quantity = Integer.parseInt(quantityInput);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid quantity.");
                continue;
            }

            if (quantity <= 0) {
                System.out.println("Quantity must be greater than 0.");
                continue;
            }

            order.addItem(selectedItem, quantity);

            System.out.println(quantity + " x " +
                    selectedItem.getFoodName() +
                    " added to your order.");
        }

        if (order.getSelectedItems().isEmpty()) {
            System.out.println("\nNo items selected. Order cancelled.");
            return;
        }

        displayOrderSummary();
    }

    private void displayOrderSummary() {

        System.out.println("\n================================");
        System.out.println("          ORDER SUMMARY");
        System.out.println("================================");

        order.getCustomer().displayCustomerDetails();

        System.out.println("\nSelected Items:");

        for (Map.Entry<FoodItem, Integer> entry :
                order.getSelectedItems().entrySet()) {

            FoodItem item = entry.getKey();
            int quantity = entry.getValue();

            int itemTotal = item.getPrice() * quantity;

            System.out.println(
                    quantity + " x " + item.getFoodName() +
                            " @ Rs. " + item.getPrice() +
                            " = Rs. " + itemTotal
            );
        }

        System.out.println("--------------------------------");
        System.out.println("Total Payable Amount: Rs. " +
                payment.calculateTotal());

        System.out.println("--------------------------------");
        System.out.println("Your order has been placed successfully!");
        System.out.println("Thank you for ordering from Foodie's Hub.");
    }
}
