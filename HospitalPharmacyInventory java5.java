package BM23AI069;

 import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

    class InventoryItem {
        private String id;
        private String name;
        private int quantity;
        private double price;

        public InventoryItem(String id, String name, int quantity, double price) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public int getQuantity() { return quantity; }
        public double getPrice() { return price; }

        public void setName(String name) { this.name = name; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
        public void setPrice(double price) { this.price = price; }

        @Override
        public String toString() {
            return String.format("ID: %s | Name: %s | Quantity: %d | Price: %.2f", id, name, quantity, price);
        }
    }

    class InventoryManager {
        private final List<InventoryItem> items = new ArrayList<>();

        public boolean addItem(InventoryItem item) {
            if (findItemById(item.getId()).isPresent()) {
                return false; 
            }
            items.add(item);
            return true;
        }

        public boolean updateItem(String id, String newName, Integer newQuantity, Double newPrice) {
            Optional<InventoryItem> optItem = findItemById(id);
            if (optItem.isEmpty()) {
                return false;
            }
            InventoryItem item = optItem.get();
            if (newName != null) item.setName(newName);
            if (newQuantity != null) item.setQuantity(newQuantity);
            if (newPrice != null) item.setPrice(newPrice);
            return true;
        }

        public boolean removeItem(String id) {
            return items.removeIf(item -> item.getId().equals(id));
        }

        public void displayAllItems() {
            if (items.isEmpty()) {
                System.out.println("Inventory is empty.");
                return;
            }
            System.out.println("Inventory List:");
            for (InventoryItem item : items) {
                System.out.println(item);
            }
        }

        public Optional<InventoryItem> findItemById(String id) {
            return items.stream().filter(item -> item.getId().equals(id)).findFirst();
        }
    }

    public class HospitalPharmacyInventory {
        public static void main(String[] args) {
            InventoryManager inventory = new InventoryManager();

            inventory.addItem(new InventoryItem("M001", "Paracetamol", 100, 0.50));
            inventory.addItem(new InventoryItem("M002", "Amoxicillin", 50, 1.20));
            inventory.addItem(new InventoryItem("S001", "Syringe", 200, 0.15));

            inventory.displayAllItems();

            boolean updated = inventory.updateItem("M001", null, 120, null);
            System.out.println(updated ? "Item M001 updated." : "Item M001 not found.");

            inventory.findItemById("M002").ifPresentOrElse(
                    item -> System.out.println("Found item: " + item),
                    () -> System.out.println("Item M002 not found.")
            );

            boolean removed = inventory.removeItem("S001");
            System.out.println(removed ? "Item S001 removed." : "Item S001 not found.");

            inventory.displayAllItems();
        }
    }





