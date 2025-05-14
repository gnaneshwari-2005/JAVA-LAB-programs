package BM23AI069;
import java.util.Vector;

class Product {
    String name;
    double price;
    String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", category='" + category + "'}";
    }
}

public class ONLINESHOPPINGMANAGER {
    private Vector<Product> inventory;

    public ONLINESHOPPINGMANAGER () {
        inventory = new Vector<>();
    }

    public void addProduct(String name, double price, String category) {
        Product product = new Product(name, price, category);
        inventory.add(product);
    }

    public void removeProduct(String name) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).name.equalsIgnoreCase(name)) {
                inventory.remove(i);
                break;
            }
        }
    }

    public void displayProducts() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product product : inventory) {
                System.out.println(product);
            }
        }
    }

    public void searchProductByName(String name) {
        boolean found = false;
        for (Product product : inventory) {
            if (product.name.equalsIgnoreCase(name)) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Product not found.");
        }
    }

    public void searchProductByCategory(String category) {
        boolean found = false;
        for (Product product : inventory) {
            if (product.category.equalsIgnoreCase(category)) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found in this category.");
        }
    }

    public void updateProductPrice(String name, double newPrice) {
        for (Product product : inventory) {
            if (product.name.equalsIgnoreCase(name)) {
                product.price = newPrice;
                System.out.println("Price updated for " + name);
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public static void main(String[] args) {
        ONLINESHOPPINGMANAGER  manager = new ONLINESHOPPINGMANAGER ();

        manager.addProduct("Laptop", 1500.0, "Electronics");
        manager.addProduct("Smartphone", 700.0, "Electronics");
        manager.addProduct("Shoes", 50.0, "Clothing");

        System.out.println("All Products:");
        manager.displayProducts();

        System.out.println("\nSearch by name 'Laptop':");
        manager.searchProductByName("Laptop");

        System.out.println("\nSearch by category 'Electronics':");
        manager.searchProductByCategory("Electronics");

        System.out.println("\nUpdating price of 'Laptop' to 1600.0:");
        manager.updateProductPrice("Laptop", 1600.0);

        System.out.println("\nAll Products after price update:");
        manager.displayProducts();

        System.out.println("\nRemoving product 'Shoes':");
        manager.removeProduct("Shoes");

        System.out.println("\nAll Products after removal:");
        manager.displayProducts();
    }
}
