import java.util.List;


public class User {
    private String email;
    private String password;
    private String address;
    private String UserId;
    
    public User(String email, String password, String address, String UserId) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.UserId = UserId;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getUserId() {
        return UserId;
    }
    
    public void setUserId(String UserId) {
        this.UserId = UserId;
    }
    
    public static boolean register(String email, String password, String address, String UserId, List<User> users) {
        // Check if user with same email already exists
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return false;
            }
        }
        
        // Generate OTP and send to email
        
        // Create new User object and add to list
        User newUser = new User(email, password, address , UserId);
        users.add(newUser);
        return true;
    }
    //Map<String, User> userMap = new HashMap<>();
    public static User login(String email, String password, List<User> users) {
        // Find user with matching email and password
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        
        return null; // No matching user found
    }
    public static void main(String[] args)
    {
        System.out.println("hello");
    } 
}