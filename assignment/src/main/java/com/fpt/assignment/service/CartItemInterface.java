package com.fpt.assignment.service;

import java.util.Collection;
import java.util.Map;

import com.fpt.assignment.model.CartItem;

public interface CartItemInterface {
    void add(CartItem cartItem);

    void remove(CartItem cartItem);

    void update(CartItem cartItem, int quantity);

    void clear();

    int getCount();

    double getAmount();

    Map<String, CartItem> getDAO();

    CartItem getCartItemId(String id);

    CartItem findCartItemDB(String id);

    Collection<CartItem> getCarts();
}
