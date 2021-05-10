package com.exam.estore.services;

import com.exam.estore.dao.ProductDao;
import com.exam.estore.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService{

    @Autowired
    private ProductDao pDao;

    @Override
    @Async
    public void purchaseProduct(Product product, String amount) {
        product.setStock(product.getStock() - Integer.parseInt(amount));
        pDao.save(product);
    }
    
}
