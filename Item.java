import java.io.*;
import java.util.List;


public class Item 
{
   private String name;
   private String category;
   private String description;
   private String image;
   private String brand;
   private double price;
   private int discountPercentage;
   private int quantity;
   private boolean inStock;
   private String supplierName;
   private String productCode;

// Constructor
public Item(String name, String category, String description, String image, String brand, double price, int discountPercentage,
            int quantity, boolean inStock, String supplierName, String productCode) {
    this.name = name;
    this.category = category;
    this.description = description;
    this.image = image;
    this.brand = brand;
    this.price = price;
    this.discountPercentage = discountPercentage;
    this.quantity = quantity;
    this.inStock = inStock;
    this.supplierName = supplierName;
    this.productCode = productCode;
}

// Getters and Setters
public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getCategory() {
    return category;
}

public void setCategory(String category) {
    this.category = category;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public String getImage() {
    return image;
}

public void setImage(String image) {
    this.image = image;
}

public String getBrand() {
    return brand;
}

public void setBrand(String brand) {
    this.brand = brand;
}

public double getPrice() {
    return price;
}

public void setPrice(double price) {
    this.price = price;
}

public int getDiscountPercentage() {
    return discountPercentage;
}

public void setDiscountPercentage(int discountPercentage) {
    this.discountPercentage = discountPercentage;
}

public int getQuantity() {
    return quantity;
}

public void setQuantity(int quantity) {
    this.quantity = quantity;
}

public boolean isInStock() {
    return inStock;
}

public void setInStock(boolean inStock) {
    this.inStock = inStock;
}

public String getSupplierName() {
    return supplierName;
}

public void setSupplierName(String supplierName) {
    this.supplierName = supplierName;
}

public String getProductCode() {
    return productCode;
}

public void setProductCode(String productCode) {
    this.productCode = productCode;
}

// Save item data to file
public static void write(Item item, String fileName) throws IOException {
    FileOutputStream fileOutputStream = new FileOutputStream(fileName);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

    objectOutputStream.writeObject(item);

    objectOutputStream.close();
    fileOutputStream.close();
}

// Load item data from file
public static Item read(String fileName) throws IOException, ClassNotFoundException {
    FileInputStream fileInputStream = new FileInputStream(fileName);
    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

    Item item = (Item) objectInputStream.readObject();
    
    objectInputStream.close();
    fileInputStream.close();
    
    return item;
    }
    // Add item to shopping cart
public void addToCart(List<Item> cart) {
    if (this.inStock && this.quantity > 0) {
    cart.add(this);
    this.quantity--;
    }
    }
    
    // Remove item from shopping cart
    public void removeFromCart(List<Item> cart) {
    if (cart.contains(this)) {
    cart.remove(this);
    this.quantity++;
    }
    }
    public static void main(String[] args) {
    }
    }
