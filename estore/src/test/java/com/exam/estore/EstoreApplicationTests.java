package com.exam.estore;

import javax.transaction.Transactional;

import com.exam.estore.dao.ProductDao;
import com.exam.estore.services.PurchaseService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EstoreApplicationTests {
	@Autowired
	PurchaseService pService;

	@Autowired
	ProductDao pDao;

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	void testWriteLock() throws Exception {
		pService.purchaseProductWriteLock("1", 1, "1");
		pService.purchaseProductWriteLock("2", 1, "1");
		
		// for some reason need to wait before asserting, 
		// otherwise assertion fails and all db transactions rolled back
		Thread.sleep(1000);
		Assertions.assertEquals(3, pDao.getOne(1).getStock());
	}

	@Test
	@Transactional
	void testOptLock() throws Exception {
		pService.purchaseProductOpt("1", 1, "1");
		pService.purchaseProductOpt("2", 1, "1");

		Thread.sleep(1000);
	}
}
