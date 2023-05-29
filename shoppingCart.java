import java.util.ArrayList;
import java.util.List;


public class shoppingCart {
  
    private List<Item> items; // The list of items in the shopping cart
    public User user;

    public shoppingCart(User user) {
        this.items = new ArrayList<>();
    }
    
    public void addItem(Item item, int quantity) {
        // Check if the item is already in the cart
        boolean found = false;
        for (Item i : items) {
            if (i.getName().equals(item.getName())) {
                i.setQuantity(i.getQuantity() + quantity);
                found = true;
                break;
            }
        }
        
        // If not found, add the item with the specified quantity to the cart
        if (!found) {
            item.setQuantity(quantity);
            items.add(item);
        }
    }
    
    public void removeItem(Item item, int quantity) {
        // Find the item in the cart and update its quantity
        for (Item i : items) {
            if (i.getName().equals(item.getName())) {
                int newQuantity = i.getQuantity() - quantity;
                if (newQuantity <= 0) {
                    items.remove(i);
                } else {
                    i.setQuantity(newQuantity);
                }
                break;
            }
        }
    }
    
    public double getTotalCost() {
        double totalCost = 0.0;
        for (Item item : items) {
            totalCost += item.getPrice() * item.getQuantity();
        }
        return totalCost;
    }
    
    public void clear() {
        items.clear();
    }

    public void checkout(String paymentMethod, boolean paymentUponDelivery) {
        // Code to process payment and place order goes here
        
        // Save the order to file
        Order order = new Order(items, getTotalCost(), paymentMethod, paymentUponDelivery, "123 Main St", false);
        order.saveOrderToFile(order, "order.txt");
        
        // Clear the shopping cart and inform the user of successful payment
        clear();
        System.out.println("Payment successful! Thank you for your purchase.");
        
        if (paymentUponDelivery) {
            //Delivery delivery = new Delivery();
            //delivery.closeOrder(order);
        }
    }
    public static void main(String[] args)
    {
        System.out.println("hello");
    } 
}
