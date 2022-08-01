package com.fpt.assignment.serviceImpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.fpt.assignment.data.DB;
import com.fpt.assignment.model.CartItem;
import com.fpt.assignment.service.CartItemInterface;

@Service
@SessionScope
public class CartProductService implements CartItemInterface{
    @Autowired
    DB db;

    private Map<String, CartItem> your_cart = new HashMap<>();

    @Override
    public void add(CartItem cartItem) {
        your_cart.put(cartItem.getId(), cartItem);
    }

    @Override
    public void remove(CartItem cartItem) {
        your_cart.remove(cartItem.getId());        
    }

    @Override
    public void update(CartItem cartItem, int quantity) {
        cartItem.setQty(quantity);
        your_cart.replace(cartItem.getId(), cartItem);
    }

    @Override
    public void clear() {
        your_cart.clear();
    }

    @Override
    public int getCount() {
        return your_cart.values().size();
    }

    @Override
    public double getAmount() {
        return your_cart.values().stream().mapToDouble(item -> item.getProduct().getPrice() * item.getQty()).sum();
    }

    @Override
    public CartItem getCartItemId(String id) {
        return your_cart.get(id) == null ? null : your_cart.get(id);
    }

    @Override
    public Collection<CartItem> getCarts() {
        return your_cart.values();
    }

    @Override
    public CartItem findCartItemDB(String id) {
        return db.getDBProducts().get(id);
    }

    @Override
    public Map<String, CartItem> getDAO() {
        return your_cart;
    }
}
