package com.exam.estore.services;

import com.exam.estore.models.Product;

public interface PurchaseService {
    void purchaseProduct(Product product, String amount);
}
