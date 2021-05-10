package com.exam.estore.services;

import com.exam.estore.models.Product;

public interface PurchaseService {
    void purchaseProduct(int productID, String amount);
    void purchaseProductWriteLock(String threadNo, int productID, String amount) throws InterruptedException;
}
