package managing_item;
import java.util.*;

class Product {
    String sku;
    String name;
    int quantity;

    Product(String sku, String name, int quantity) {
        this.sku = sku;
        this.name = name;
        this.quantity = quantity;
    }
}

public class project_01 {
    static ArrayList<Product> inventory = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Insert new product
    public static void insertProduct() {
        System.out.print("Enter SKU: ");
        String sku = sc.nextLine();

        // Check for duplicate SKU
        for (Product p : inventory) {
            if (p.sku.equals(sku)) {
                System.out.println("Product with this SKU already exists!");
                return;
            }
        }

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Error: Product name cannot be empty.");
            return;
        }

        System.out.print("Enter Quantity: ");
        int quantity;
        try {
            quantity = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity. Must be a number.");
            return;
        }
        if (quantity <= 0) {
            System.out.println("Error: Quantity must be positive.");
            return;
        }

        inventory.add(new Product(sku, name, quantity));
        System.out.println("Product inserted successfully.");
    }

    // Search by SKU
    public static void searchBySKU() {
        System.out.print("Enter SKU to search: ");
        String sku = sc.nextLine();
        for (Product p : inventory) {
            if (p.sku.equals(sku)) {
                System.out.println("Product Found: " + p.sku + " - " + p.name + " - " + p.quantity);
                return;
            }
        }
        System.out.println("No product found with SKU: " + sku);
    }

    // Search by Name
    public static void searchByName() {
        System.out.print("Enter Name to search: ");
        String name = sc.nextLine();
        for (Product p : inventory) {
            if (p.name.equalsIgnoreCase(name)) {
                System.out.println("Product Found: " + p.sku + " - " + p.name + " - " + p.quantity);
                return;
            }
        }
        System.out.println("No product found with name: " + name);
    }

    // Delete product by SKU
    public static void deleteProduct() {
        System.out.print("Enter SKU to delete: ");
        String sku = sc.nextLine();
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).sku.equals(sku)) {
                inventory.remove(i);
                System.out.println("Product removed successfully.");
                return;
            }
        }
        System.out.println("No product found with SKU: " + sku);
    }

    // Update quantity of a product
    public static void updateQuantity() {
        System.out.print("Enter SKU to update: ");
        String sku = sc.nextLine();
        for (Product p : inventory) {
            if (p.sku.equals(sku)) {
                System.out.print("Enter new quantity: ");
                int quantity;
                try {
                    quantity = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid quantity. Must be a number.");
                    return;
                }
                if (quantity <= 0) {
                    System.out.println("Error: Quantity must be positive.");
                    return;
                }
                p.quantity = quantity;
                System.out.println("Quantity updated successfully.");
                return;
            }
        }
        System.out.println("No product found with SKU: " + sku);
    }

    // Display all products
    public static void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("\nCurrent Inventory:");
        System.out.println("SKU\t\tName\t\tQuantity");
        System.out.println("--------------------------------");
        for (Product p : inventory) {
            System.out.println(p.sku + "\t\t" + p.name + "\t\t" + p.quantity);
        }
    }

    public static void showMenu() {
        System.out.println("\nInventory Stock Manager");
        System.out.println("1. Insert New Product");
        System.out.println("2. Search by SKU");
        System.out.println("3. Search by Name");
        System.out.println("4. Delete Product by SKU");
        System.out.println("5. Update Quantity");
        System.out.println("6. Display Inventory");
        System.out.println("7. Exit");
        System.out.print("Enter choice: ");
    }

    public static void main(String[] args) {
        while (true) {
            showMenu();
            String choice = sc.nextLine();

            switch (choice) {
                case "1": insertProduct(); break;
                case "2": searchBySKU(); break;
                case "3": searchByName(); break;
                case "4": deleteProduct(); break;
                case "5": updateQuantity(); break;
                case "6": displayInventory(); break;
                case "7":
                    System.out.println("Exiting Inventory Manager.");
                    return;
                default:
                    System.out.println("Invalid choice. Please select 1-7.");
            }
        }
    }
}
