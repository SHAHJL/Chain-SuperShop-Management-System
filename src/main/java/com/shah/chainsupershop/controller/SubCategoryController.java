/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.controller;

import com.shah.chainsupershop.domain.SubCategory;
import com.shah.chainsupershop.service.ISubCategoryService;
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
@RequestMapping("/subcategory")
public class SubCategoryController {

    @Autowired
    private ISubCategoryService iSubCategoryService;

    @RequestMapping("/home")
    public String home() {
        return "subcategory";
    }

    @RequestMapping(value = "/subcat/{id}", method = RequestMethod.GET)
    public ResponseEntity<SubCategory> getObjectById(@PathVariable("id") Integer id) {
        SubCategory subcat = iSubCategoryService.getObjectById(id);
        return new ResponseEntity<SubCategory>(subcat, HttpStatus.OK);
    }

    @RequestMapping(value = "/subcat", method = RequestMethod.GET)
    public ResponseEntity<List<SubCategory>> getAllSubCategory() {
        List<SubCategory> list = iSubCategoryService.getAllObject();
        return new ResponseEntity<List<SubCategory>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/subcat", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody SubCategory subcat, UriComponentsBuilder builder) {
        boolean flag = iSubCategoryService.addObject(subcat);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/subcat/{id}").buildAndExpand(subcat.getSubCatId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/subcat/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SubCategory> updateSubCategory(@RequestBody SubCategory subcat) {
        iSubCategoryService.updateObject(subcat);
        return new ResponseEntity<SubCategory>(subcat, HttpStatus.OK);
    }

    @RequestMapping(value = "/subcat/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        iSubCategoryService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
