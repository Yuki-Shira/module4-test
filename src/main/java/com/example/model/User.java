package com.example.model;

/**
 * Represents a user in the system.
 */
public class User {

    private String id;
    private String name;
    private String email;
    private int age;
    private String phone;

    /**
     * Creates a new User with the given identifier.
     *
     * @param id the unique user identifier
     */
    public User(String id) {
        this.id = id;
    }

    /**
     * Returns the user's unique identifier.
     *
     * @return the user ID
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the user's display name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user's display name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the user's email address.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email address.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the user's age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the user's age.
     *
     * @param age the new age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the user's phone number.
     *
     * @return the phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the user's phone number.
     *
     * @param phone the new phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
