package com.exam.estore.controllers;

import java.util.List;

import com.exam.estore.dao.ProductDao;
import com.exam.estore.models.Product;
import com.exam.estore.services.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @Autowired
    private ProductDao pDao;

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping(path = "/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home.jsp");

        List<Product> products = pDao.findAll();

        mv.addObject("products", products);
        return mv;
    }

    @PostMapping(path = "product/{id}/buy")
    public String buyProduct(@PathVariable("id") int id,
                                        @RequestParam(name = "amount") String amount                        
    ) {
        Product product = pDao.getOne(id);
        purchaseService.purchaseProduct(product, amount);

        return "redirect:/";
    }
}
