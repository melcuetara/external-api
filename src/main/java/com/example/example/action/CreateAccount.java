package com.example.example.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.example.ExampleSupport;
import com.example.example.model.User;

public class CreateAccount extends ExampleSupport{

    private String error = "";
    private User user;
    private String username;
    private String password;

    public String execute() {

        if (!emptyForm(username) || !emptyForm(password)) {
            if (insertData()) {
                return SUCCESS;
            } else {
                return ERROR;
            }          
        } else {
            error = "empty";
            return INPUT;
        }
        

    }

    public boolean insertData() {
        user = new User(username, password);
        Connection connection = null;
        Statement statement = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "meljamaica");

            if (connection != null) {
                statement = connection.createStatement();
                String sql = "INSERT INTO user(username, password) VALUES('" +user.getUsername()+"','"+user.getPassword()+"')";
                statement.executeUpdate(sql);
                return true;
            } else {
                error = "DB connection failed";
                return false;
            }
         } catch (Exception e) {
             error = e.toString();
             return false;  
         } finally {
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
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

    public boolean emptyForm(String value) {

        return value == null || value.length() == 0;
    }
    
}