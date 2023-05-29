import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Order {
private static int idCounter = 1;
private int id;
private List<Item> items;
private double totalCost;
private String paymentMethod;
private boolean paymentUponDelivery;
private String shippingAddress;
private boolean isClosed;

public Order(List<Item> items, double totalCost, String paymentMethod, boolean paymentUponDelivery, String shippingAddress, boolean isClosed) {
    this.id = idCounter++;
    this.items = items;
    this.totalCost = totalCost;
    this.paymentMethod = paymentMethod;
    this.paymentUponDelivery = paymentUponDelivery;
    this.shippingAddress = shippingAddress;
    this.isClosed = isClosed;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public List<Item> getItems() {
    return items;
}

public void setItems(List<Item> items) {
    this.items = items;
}

public double getTotalCost() {
    return totalCost;
}

public void setTotalCost(double totalCost) {
    this.totalCost = totalCost;
}

public String getPaymentMethod() {
    return paymentMethod;
}

public void setPaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
}

public boolean isPaymentUponDelivery() {
    return paymentUponDelivery;
}

public void setPaymentUponDelivery(boolean paymentUponDelivery) {
    this.paymentUponDelivery = paymentUponDelivery;
}

public String getShippingAddress() {
    return shippingAddress;
}

public void setShippingAddress(String shippingAddress) {
    this.shippingAddress = shippingAddress;
}

public boolean isClosed() {
    return isClosed;
}

public void setClosed(boolean closed) {
    isClosed = closed;
}

public void saveOrderToFile(Order order, String fileName) {
    try (FileWriter fileWriter = new FileWriter(fileName)) {
        fileWriter.write("ID: " + order.getId() + "\n");
        fileWriter.write("Items:\n");
        for (Item item : order.getItems()) {
            fileWriter.write(item.getName() + ", " + item.getPrice() + ", " + item.getQuantity() + "\n");
        }
        fileWriter.write("Total Cost: " + order.getTotalCost() + "\n");
        fileWriter.write("Payment Method: " + order.getPaymentMethod() + "\n");
        fileWriter.write("Payment Upon Delivery: " + order.isPaymentUponDelivery() + "\n");
        fileWriter.write("Shipping Address: " + order.getShippingAddress() + "\n");
        fileWriter.write("Is Closed: " + order.isClosed() + "\n");
    } catch (IOException e) {
        System.out.println("An error occurred while saving the order to file.");
        e.printStackTrace();
    }
}


public static void main(String[] args) {
    
}
}



  

      