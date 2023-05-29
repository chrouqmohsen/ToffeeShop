import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // إنشاء list of Items
        List<Item> cart = new ArrayList<>();
        Item item1 = new Item("Product 1", "Category 1", "Description 1", "image1.jpg", 
                              "Brand 1", 100.0, 10, 5, true, "Supplier 1", "P1");

        // استخدام الأسلوب "addToCart" في الكلاس Item
        item1.addToCart(cart);
        
        if (cart.contains(item1)) {
            System.out.println("Item added to cart.");
        } else {
            System.out.println("Item not available.");
        }

        // إنشاء list of Users
        List<User> users = new ArrayList<>();
        users.add(new User("user1@example.com", "password1", "Address 1", "1"));
        users.add(new User("user2@example.com", "password2", "Address 2", "2"));

        // استخدام الأساليب المتاحة في الكلاس User (register، login)
        boolean isRegistered = User.register("user3@example.com", "password3", "Address 3", "3", users);
        if (isRegistered) {
            System.out.println("Registration successful.");
            System.out.println("Please login with your credentials.");
        } else {
            System.out.println("Registration failed. Email already exists.");
            System.out.println("Please try again with a different email.");
        }

        boolean isLoggedIn = User.login("user2@example.com", "password2", users) != null;

        if (isLoggedIn) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid email or password.");
        }

        Item item2 = new Item("Product 2", "Category 1", "Description 2", "image2.jpg", 
                              "Brand 2", 200.0, 15, 3, true, "Supplier 2", "P2");
        Item item3 = new Item("Product 3", "Category 2", "Description 3", "image3.jpg", 
                              "Brand 3", 50.0, 20, 10, true, "Supplier 3", "P3");

        cart.add(item2);
        cart.add(item3);

        shoppingCart myCart = new shoppingCart(users.get(0));
        myCart.addItem(item1, 2);
        myCart.addItem(item2, 1);

        myCart.checkout("Credit Card", false);

        double total = myCart.getTotalCost();
        System.out.println("Total price: " + total);

        // حفظ تفاصيل الطلب في ملف نصي
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        Order order = new Order(items, total, "Credit Card", false,
                                users.get(0).getEmail(), false);

        order.setItems(items);
        order.setTotalCost(total);
        //order.setUser(users.get(0));

        try {
            FileWriter writer = new FileWriter("order.txt");
            writer.write(order.toString());
            writer.close();
            System.out.println("Order details saved to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the order details.");
            e.printStackTrace();
        }
    }
}
