package com.exam.estore.controllers;

import java.util.List;

import com.exam.estore.dao.ProductDao;
import com.exam.estore.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @Autowired
    private ProductDao pDao;

    @GetMapping(path = "/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home.jsp");

        List<Product> products = pDao.findAll();

        mv.addObject("products", products);
        return mv;
    }
}
