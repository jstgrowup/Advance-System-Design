// Access modifiers 
package users;
public class User {
    protected String role = "Admin";
    private String password = "sdfsad";
    public String personalName = "Suraj";
//   This is a default keyword
String name = "suraj";
  
    void printPassword() {
        System.out.println(password);
    }
}

class Main {
    public static void main(String[] args) {
        User user = new User();
        // We cant access the private properties at all other than the same object
        // System.out.println(user.password);
// 
    }
}
// A protected member can be accessed inside the same class , inside the