/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.controller;

import com.shah.chainsupershop.domain.Product;
import com.shah.chainsupershop.service.IProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author SHAH
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping("/home")
    public String home() {
        return "product";
    }
    
     @RequestMapping(value = "/prolist/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product>getObjectById(@PathVariable("id") Integer id) {
        Product product = iProductService.getObjectById(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/prolist", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> list = iProductService.getAllObject();
        return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/prolist", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody Product product, UriComponentsBuilder builder) {
        boolean flag = iProductService.addObject(product);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/prolist/{id}").buildAndExpand(product.getProductId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/prolist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        iProductService.updateObject(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/prolist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        iProductService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
