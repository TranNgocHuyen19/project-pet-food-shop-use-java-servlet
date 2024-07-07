/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Trần Ngọc Huyền
 */
public class Cart {
    private List<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public Cart(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
    
    //get quantity by id
    public int getQuantityById(long  id) {
        return getItemById(id).getQuantity();
    }
    
    //find item by id
    private CartItem getItemById(long id) {
        for (CartItem i : items) {
            if(i.getProduct().getId() == id) 
                return i;
        }
        return null;
    }
    
    //add item 
    public void addItem(CartItem t) {
        if(getItemById(t.getProduct().getId()) != null) {
            CartItem m = getItemById(t.getProduct().getId());
            m.setQuantity(m.getQuantity() + t.getQuantity());
        } else {
            items.add(t);
        }
    }
    
    //remove item
    public void removeItem(long id){
        if(getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }
    
    //get total money 
    public double getTotalMoney() {
        double total = 0;
        for(CartItem i: items){
            total += (i.getQuantity() * i.getPrice());
        }
        return total;
    }
    
}
