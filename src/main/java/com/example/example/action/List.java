package com.example.example.action;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Connection;                
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.example.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class List extends ActionSupport {

    String input;
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<String> username = new ArrayList<String>();

    public ArrayList<String> getUsername() {
        return username;
    }

    public void setUsername(ArrayList<String> username) {
        this.username = username;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
    public ArrayList<User> getUsers() {  
        return users;  
    }  
    public void setList(ArrayList<User> users) {  
        this.users = users;  
    }  

    public String execute() throws Exception {
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

                while(rs.next()){  
                    User user = new User();
                    user.setUsername(rs.getString(2));   
                    user.setPassword(rs.getString(3));
                    users.add(user);  
                    username.add(user.getUsername());
                }
            } 
         } catch (Exception e) {

         } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }

         return SUCCESS;
    }

    public String displayUser() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "meljamaica");

            if (connection != null) {
                String sql = "SELECT * FROM user where username = '" + input + "'";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    User user = new User();
                    user.setUsername(rs.getString(2));
                    user.setPassword(rs.getString(3));
                    users.add(user);
                }
            }
        } catch (Exception e) {
        } finally {
            if (preparedStatement != null)
                try {
                    preparedStatement.close();
                } catch (SQLException ignore) {
                }
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException ignore) {
                }
        }
        return SUCCESS;
    }
}