package Src.model;

public class StockMovement {
    private int movementId;
    private int productId;
    private String movementType; // "IN" or "OUT"
    private int quantityChanged;
    private String timestamp;

    public StockMovement(int movementId, int productId, String movementType, int quantityChanged, String timestamp) {
        this.movementId = movementId;
        this.productId = productId;
        this.movementType = movementType;
        this.quantityChanged = quantityChanged;
        this.timestamp = timestamp;
    }

    public int getMovementId() { return movementId; }
    public void setMovementId(int movementId) { this.movementId = movementId; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getMovementType() { return movementType; }
    public void setMovementType(String movementType) { this.movementType = movementType; }

    public int getQuantityChanged() { return quantityChanged; }
    public void setQuantityChanged(int quantityChanged) { this.quantityChanged = quantityChanged; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}