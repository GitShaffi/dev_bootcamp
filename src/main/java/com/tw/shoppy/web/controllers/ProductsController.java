package com.tw.shoppy.web.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.tw.shoppy.models.Product;
import com.tw.shoppy.web.views.View;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController extends BaseController{
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    @JsonView(View.ProductListing.class)
    public void create(@RequestBody Product product) {
        product.saveIt();
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    @JsonView(View.ProductListing.class)
    public List<Product> get() {
        return Product.REPO.all();
    }

}