package campus_cafe;

import campus_cafe.data.*;
import campus_cafe.model.*;

import java.util.*;
import java.math.BigDecimal;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Order order = new Order();
        Menu menu = new Menu();
        
        String menuOption = getMenuOption(menu);
        while (!menuOption.equalsIgnoreCase("end")) {

            Product item = menu.getMenuItem(menuOption);
            if (item == null) {
                System.out.println("Your selection is invalid");
                menuOption = getMenuOption(menu);   // FIX: must reprompt
                continue;
            }

            // Quantity
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            item.setQuantity(quantity);

            // Beverage size
            if (item instanceof Beverage) {
                BeverageSize beverageSize = getBeverageSize();
                ((Beverage) item).setBeverageSize(beverageSize);
            }

            // Addons for food
            if (item instanceof Food) {
                Addon addon = getAddon();
                ((Food) item).setAddon(addon);
            }

            order.addLineItem(item);

            System.out.println(String.format(
                "\nYou selected: %s -- %s -- %.2f -- total price: %.2f",
                item.getId(), item.getName(),
                item.getBasePrice(), item.price()
            ));

            menuOption = getMenuOption(menu);
        }

        System.out.println("\n--- End of Order ---\n");

        // Print line items
        List<String> lineItems = order.getFormattedLineItems();
        for (String lineItem : lineItems) {
            System.out.println(lineItem);
        }

        BigDecimal tax = order.calculateTotalSalesTax();
        System.out.println(String.format("\nSales Tax: %.2f", tax));
    }

    // -----------------------------------------------------------------
    // CORRECT getBeverageSize()
    // -----------------------------------------------------------------
    private static BeverageSize getBeverageSize() {
        System.out.print("Please select (S)mall, (M)edium, or (L)arge: ");
        String size = sc.nextLine().trim().toUpperCase();

        if (size.equals("M") || size.startsWith("MEDIUM"))
            return BeverageSize.MEDIUM;
        if (size.equals("L") || size.startsWith("LARGE"))
            return BeverageSize.LARGE;

        return BeverageSize.SMALL;
    }

    // -----------------------------------------------------------------
    // CORRECT getAddon()
    // -----------------------------------------------------------------
    private static Addon getAddon() {
        System.out.print("Extra Cheese? (Y)es / (N)o: ");
        String input = sc.nextLine().trim().toUpperCase();

        if (input.equals("Y") || input.startsWith("CHEESE"))
            return Addon.cheese;

        return Addon.nocheese;   // NEVER return null
    }

    // -----------------------------------------------------------------
    private static String getMenuOption(Menu menu) {
        menu.DisplayMenu();
        System.out.print("\nPlease make selection: ");
        return sc.nextLine();
    }
}
