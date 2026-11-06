package Src.ui;

import Src.data.*;
import Src.model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final ProductDao productDao = new ProductDao();
    private final SupplierDao supplierDao = new SupplierDao();
    private final StockMovementDao movementDao = new StockMovementDao();
    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Add Supplier");
            System.out.println("4. View All Suppliers");
            System.out.println("5. Record Stock Movement (IN/OUT)");
            System.out.println("6. View Stock Movements");
            System.out.println("7. Update Product");
            System.out.println("8. Delete Product");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewProducts();
                case 3 -> addSupplier();
                case 4 -> viewSuppliers();
                case 5 -> recordStockMovement();
                case 6 -> viewStockMovements();
                case 7 -> updateProduct();
                case 8 -> deleteProduct();
                case 0 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter unit price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter initial quantity in stock: ");
        int qty = scanner.nextInt();

        Product product = new Product(0, name, price, qty);
        productDao.addProduct(product);
    }

    private void viewProducts() {
        List<Product> products = productDao.getAllProducts();
        System.out.println("\n--- Product List ---");
        for (Product p : products) {
            System.out.println("ID: " + p.getProductId() + " | Name: " + p.getName() + 
                               " | Price: $" + p.getUnitPrice() + " | Stock: " + p.getQuantityInStock());
        }
    }

    private void addSupplier() {
        System.out.print("Enter supplier name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact person: ");
        String contact = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Supplier supplier = new Supplier(0, name, contact, phone, email);
        supplierDao.addSupplier(supplier);
    }

    private void viewSuppliers() {
        List<Supplier> suppliers = supplierDao.getAllSuppliers();
        System.out.println("\n--- Supplier List ---");
        for (Supplier s : suppliers) {
            System.out.println("ID: " + s.getSupplierId() + " | Name: " + s.getName() + 
                               " | Contact: " + s.getContactPerson() + " | Phone: " + s.getPhone());
        }
    }

    private void recordStockMovement() {
        System.out.print("Enter Product ID for movement: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter movement type (IN / OUT): ");
        String type = scanner.nextLine().toUpperCase();
        System.out.print("Enter quantity changed: ");
        int qty = scanner.nextInt();
        scanner.nextLine();

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        StockMovement movement = new StockMovement(0, productId, type, qty, timestamp);
        movementDao.addStockMovement(movement);
    }

    private void viewStockMovements() {
        List<StockMovement> movements = movementDao.getAllStockMovements();
        System.out.println("\n--- Stock Movements Log ---");
        for (StockMovement m : movements) {
            System.out.println("Movement ID: " + m.getMovementId() + " | Product ID: " + m.getProductId() + 
                               " | Type: " + m.getMovementType() + " | Qty: " + m.getQuantityChanged() + 
                               " | Time: " + m.getTimestamp());
        }
    }

    private void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new unit price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter new quantity in stock: ");
        int qty = scanner.nextInt();
        scanner.nextLine();

        Product updatedProduct = new Product(id, name, price, qty);
        productDao.deleteProduct(id);
        productDao.addProduct(updatedProduct);
    }
    private void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        productDao.deleteProduct(id);
    }
}