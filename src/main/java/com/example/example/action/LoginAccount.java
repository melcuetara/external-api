package com.example.example.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.example.ExampleSupport;
import com.example.example.HashPassword;
import com.example.example.model.User;

public class LoginAccount extends ExampleSupport {

    private String token ="";
    private String error = "";
    private User user;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String encryptedPassword;

    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String execute() {

        if (!emptyForm(username) || !emptyForm(password)) {
            HashPassword hashPassword = new HashPassword();
            encryptedPassword = hashPassword.getHash(password);
            user = new User(username, encryptedPassword);
            if (userFound()) {
                return SUCCESS;
            } else {
                return ERROR;
            }          
        } else {
            error = "empty";
            return INPUT;
        }
    }

    public boolean userFound() {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            String URL = "jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "meljamaica");

            if (connection != null) {
                String sql = "SELECT * FROM user";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs= preparedStatement.executeQuery();

                while (rs.next()) {
                    username = rs.getString(2);
                    password = rs.getString(3);
                    if (user.getUsername().equals(rs.getString(2)) 
                        && user.getPassword().equals(rs.getString(3))) {
                        error = "Account Found";
                        return true;
                    }
                }
                error = "Account not Found";
                return false;
            } else {
                error = "DB connection failed";
                return false;
            }
         } catch (Exception e) {
             error = "Exception: " + e.toString();
             return false;  
         } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean emptyForm(String value) {

        return value == null || value.length() == 0;
    }

    
}