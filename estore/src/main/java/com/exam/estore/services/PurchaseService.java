package com.exam.estore.services;

public interface PurchaseService {
    void purchaseProduct(int productID, String amount);
    void purchaseProductWriteLock(String threadNo, int productID, String amount) throws InterruptedException;
    void purchaseProductOpt(String threadNo, int productID, String amount) throws InterruptedException;
}
