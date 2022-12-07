package ra.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int productId;
    private String productName;
    private float price;
    private int quantity;
    private String title;
    private String productImage;
    private boolean productStatus;
    private int catalogId ;
    private String descriptions;
    private List<String> listImage = new ArrayList<>();

    public Product() {
    }

    public Product(int productId, String productName, float price, int quantity, String title, String productImage, boolean productStatus, int catalogId, String descriptions, List<String> listImage) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.title = title;
        this.productImage = productImage;
        this.productStatus = productStatus;
        this.catalogId = catalogId;
        this.descriptions = descriptions;
        this.listImage = listImage;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public List<String> getListImage() {
        return listImage;
    }

    public void setListImage(List<String> listImage) {
        this.listImage = listImage;
    }
}
