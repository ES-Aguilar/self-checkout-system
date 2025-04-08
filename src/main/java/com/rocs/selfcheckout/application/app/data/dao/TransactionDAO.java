package com.rocs.selfcheckout.application.app.data.dao;

import com.rocs.selfcheckout.application.app.data.connection.ConnectionHelper;
import com.rocs.selfcheckout.application.app.data.model.Customers;
import com.rocs.selfcheckout.application.app.data.model.Items;

import java.sql.*;
import java.util.Optional;

public class TransactionDAO {
    public Optional<Items> getItemById(String itemId) {
        String sql = "SELECT * FROM items WHERE item_id = ?";
        try (Connection conn = ConnectionHelper.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, itemId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new Items(
                        rs.getString("item_id"),
                        rs.getString("item_des"),
                        rs.getDouble("unit_price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Customers> getCustomerById(String customerId) {
        String sql = "SELECT * FROM customers WHERE customer_id = ?";
        try (Connection conn = ConnectionHelper.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new Customers(
                        rs.getString("customer_id"),
                        rs.getString("customer"),
                        rs.getString("address"),
                        rs.getString("contact_number")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean saveTransaction(int transactionId, String itemId, String customerId, int qty, java.sql.Date transDate) {
        String sql = "INSERT INTO transactions (transaction_id, item_id, customer_id, qty, trans_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionHelper.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, transactionId);
            stmt.setString(2, itemId);
            stmt.setString(3, customerId);
            stmt.setInt(4, qty);
            stmt.setDate(5, transDate);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
