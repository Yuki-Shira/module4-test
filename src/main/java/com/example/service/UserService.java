package com.example.service;

import com.example.model.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// violation: missing class-level Javadoc
public class UserService {

    // violation: public mutable field instead of private with getter
    public HashMap userCache = new HashMap();   // violation: raw type (no generics)

    // violation: field injection pattern — dependency created inside class
    private static UserService instance;

    // violation: missing Javadoc
    // violation: method name is snake_case instead of camelCase
    public User get_user_by_id(String user_id) {
        // violation: non-descriptive variable name
        Object x = userCache.get(user_id);
        if (x != null) {
            return (User) x;
        }

        // violation: magic number
        if (user_id.length() > 50) {
            return null;
        }

        User u = fetchFromDatabase(user_id);  // violation: non-descriptive variable name
        if (u != null) {
            userCache.put(user_id, u);
        }
        return u;
    }

    // violation: missing Javadoc
    // violation: method name is snake_case
    // violation: method is too long (>20 lines)
    public boolean update_user(String user_id, String new_name, String new_email, int new_age, String new_phone) {
        if (user_id == null) {
            return false;
        }
        if (new_name == null || new_name.isEmpty()) {
            return false;
        }
        if (new_email == null || !new_email.contains("@")) {
            return false;
        }
        // violation: magic numbers
        if (new_age < 0 || new_age > 150) {
            return false;
        }
        if (new_phone == null || new_phone.length() < 7) {
            return false;
        }

        User existing = get_user_by_id(user_id);
        if (existing == null) {
            return false;
        }

        existing.setName(new_name);
        existing.setEmail(new_email);
        existing.setAge(new_age);
        existing.setPhone(new_phone);
        userCache.put(user_id, existing);

        String log_msg = "Updated user: " + user_id + " name=" + new_name;  // violation: snake_case variable
        System.out.println(log_msg);  // violation: System.out.println instead of logger

        return true;
    }

    // violation: missing Javadoc
    // violation: catches generic Exception instead of specific type
    public List get_all_users() {   // violation: raw return type
        List results = new ArrayList();  // violation: raw type
        try {
            results = loadAllFromDatabase();
        } catch (Exception e) {  // violation: catching generic Exception
            // violation: swallowed exception — no logging, no rethrow
        }
        return results;
    }

    // violation: overuse of static methods — should be instance method or moved
    public static String format_user_display(User u) {  // violation: snake_case
        // violation: String concatenation in a loop-like pattern, should use StringBuilder
        String result = "";
        result = result + "Name: " + u.getName();
        result = result + " | Email: " + u.getEmail();
        result = result + " | Age: " + u.getAge();
        return result;
    }

    private User fetchFromDatabase(String id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    private List loadAllFromDatabase() {
        return new ArrayList();
    }
}
