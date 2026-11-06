package Src.model;

public class Product {
    private int productId;
    private String name;
    private double unitPrice;
    private int quantityInStock;
    public Product(int productId,String name,double unitPrice,int quantityInStock){
        this.productId=productId;
        this.name=name;
        this.unitPrice=unitPrice;
        this.quantityInStock=quantityInStock;
    }
    public int getProductId(){return productId;}
    public void setProductId(int productId){this.productId=productId;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public double getUnitPrice(){return unitPrice;}
    public void setUnitPrice(double unitPrice){this.unitPrice=unitPrice;}
    public int getQuantityInStock(){return quantityInStock;}
    public void setQuantityInStock(int quantityInStock){this.quantityInStock=quantityInStock;}
    
}
