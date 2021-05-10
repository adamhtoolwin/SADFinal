package com.exam.estore.services;

import java.time.LocalTime;

import javax.transaction.Transactional;

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
	@Transactional
    @Async
    public void purchaseProduct(int productID, String amount) {
        Product product = pDao.getOne(productID);
        product.setStock(product.getStock() - Integer.parseInt(amount));
        pDao.save(product);
    }

    @Override
    @Transactional
    @Async
	public void purchaseProductWriteLock(String threadNo, int productID, String amount) throws InterruptedException {
		
		System.out.println(LocalTime.now() + " <-- Thread " + threadNo + " Buying Product -->");

		Product product2 = null;

		try {
			product2 = pDao.findProductForWrite(productID);
		} catch (Exception e) {
			System.err
					.println(LocalTime.now() + " -- Got exception while " + 
			"acquiring the write lock:\n " + e + " --");
			return;
		}
		
		System.out.println(LocalTime.now() + " -- Thread " + threadNo + " Acquired write lock on " + product2.getName() + " -->");
        product2.setStock(product2.getStock() - Integer.parseInt(amount));
        pDao.save(product2);

		System.out.println(LocalTime.now() + " -- Thread " + threadNo + " updated product: " + product2 
				+ " --");
	}
    
}
