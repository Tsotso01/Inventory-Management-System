package Src.data;

import Src.model.StockMovement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockMovementDao {

    // Method to record a stock movement (IN/OUT)
    public void addStockMovement(StockMovement movement) {
        String sql = "INSERT INTO stock_movements(productId, movementType, quantityChanged, timestamp) VALUES(?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, movement.getProductId());
            pstmt.setString(2, movement.getMovementType());
            pstmt.setInt(3, movement.getQuantityChanged());
            pstmt.setString(4, movement.getTimestamp());
            
            pstmt.executeUpdate();
            System.out.println("Stock movement recorded successfully!");
        } catch (SQLException e) {
            System.out.println("Error recording stock movement: " + e.getMessage());
        }
    }

    // Method to get all stock movements
    public List<StockMovement> getAllStockMovements() {
        List<StockMovement> movements = new ArrayList<>();
        String sql = "SELECT * FROM stock_movements";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                StockMovement movement = new StockMovement(
                    rs.getInt("movementId"),
                    rs.getInt("productId"),
                    rs.getString("movementType"),
                    rs.getInt("quantityChanged"),
                    rs.getString("timestamp")
                );
                movements.add(movement);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching stock movements: " + e.getMessage());
        }

        return movements;
    }
}