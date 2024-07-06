/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author Trần Ngọc Huyền
 */
public class Order {
    private long id;
    private String fullName;
    private String phone;
    private String email;
    private String address;
    private LocalDateTime orderDate;
    private double totalMoney;
    private boolean status;
    private boolean active;
    private User u;

    public Order() {
    }
    
    public Order(long id) {
         this.id = id;
    }

    public Order(long id, String fullName, String phone, String email, String address, LocalDateTime orderDate, double totalMoney, boolean status, boolean active, User u) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.orderDate = orderDate;
        this.totalMoney = totalMoney;
        this.status = status;
        this.active = active;
        this.u = u;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    
    
    
}
