package Src.data;

import Src.model.Supplier;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierDao {

    // Method to add a new supplier to the database
    public void addSupplier(Supplier supplier) {
        String sql = "INSERT INTO suppliers(name, contactPerson, phone, email) VALUES(?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, supplier.getName());
            pstmt.setString(2, supplier.getContactPerson());
            pstmt.setString(3, supplier.getPhone());
            pstmt.setString(4, supplier.getEmail());
            
            pstmt.executeUpdate();
            System.out.println("Supplier added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding supplier: " + e.getMessage());
        }
    }

    // Method to get a list of all suppliers in the database
    public List<Supplier> getAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        String sql = "SELECT * FROM suppliers";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Supplier supplier = new Supplier(
                    rs.getInt("supplierId"),
                    rs.getString("name"),
                    rs.getString("contactPerson"),
                    rs.getString("phone"),
                    rs.getString("email")
                );
                suppliers.add(supplier);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching suppliers: " + e.getMessage());
        }

        return suppliers;
    }
}