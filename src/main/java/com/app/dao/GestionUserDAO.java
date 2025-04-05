package com.app.dao;

import java.sql.*;
import com.app.metier.User;

public class GestionUserDAO implements IGestionUserDAO{
    private Connection connection;

    public GestionUserDAO(Connection connection) {
        this.connection=connection;
    }
    @Override
    public User getUserByUsername(String username) {
        User user=null;
        try {
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

