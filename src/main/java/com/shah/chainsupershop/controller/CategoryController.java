/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.controller;

import com.shah.chainsupershop.domain.Category;
import com.shah.chainsupershop.service.ICategoryService;
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
 * @author R-34
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;
 
 
    @RequestMapping("/home")
    public String home() {
        return "category";
    }
    @RequestMapping(value = "/catlist", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> list = iCategoryService.getAllObject();
        return new ResponseEntity<List<Category>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/catlist/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> getObjectById(@PathVariable("id") Integer id) {
        Category category = iCategoryService.getObjectById(id);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/catlist", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody Category category, UriComponentsBuilder builder) {
        boolean flag = iCategoryService.addObject(category);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/catlist/{id}").buildAndExpand(category.getCatId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/catlist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        iCategoryService.updateObject(category);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/catlist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        iCategoryService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
