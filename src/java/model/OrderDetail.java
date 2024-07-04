/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Trần Ngọc Huyền
 */
public class OrderDetail {
    private Order o;
    private Product p;
    private double price;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(Order o, Product p, double price, int quantity) {
        this.o = o;
        this.p = p;
        this.price = price;
        this.quantity = quantity;
    }

    public Order getO() {
        return o;
    }

    public void setO(Order o) {
        this.o = o;
    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
