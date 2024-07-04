/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Trần Ngọc Huyền
 */
public class Product {

    private long id;
    private String name;
    private double price;
    private double discount;
    private int stock;
    private String description;
    private String image;
    private boolean active;
    private int viewCount;
    private Brand brand;
    private Category category;
    

    public Product() {
    }

    public Product(long id) {
        this.id = id;
    }

    public Product(long id, String name, double price, double discount, int stock, String description, String image, boolean active, int viewCount, Brand brand, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
        this.description = description;
        this.image = image;
        this.active = active;
        this.viewCount = viewCount;
        this.brand = brand;
        this.category = category;
    }

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
