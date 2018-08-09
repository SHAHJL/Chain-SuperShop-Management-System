/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.controller;

import com.shah.chainsupershop.domain.Vendor;
import com.shah.chainsupershop.service.IVendorService;
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
@RequestMapping("/vendor")
public class VendorController {
    
    @Autowired
    private IVendorService iVendorService;

    @RequestMapping("/home")
    public String home() {
        return "vendor";
    }
    
    
    @RequestMapping(value = "/vendorlist/{id}", method = RequestMethod.GET)
    public ResponseEntity<Vendor> getObjectById(@PathVariable("id") Integer id) {
        Vendor vendor = iVendorService.getObjectById(id);
        return new ResponseEntity<Vendor>(vendor, HttpStatus.OK);
    }

    @RequestMapping(value = "/vendorlist", method = RequestMethod.GET)
    public ResponseEntity<List<Vendor>> getAllVendor() {
        List<Vendor> list = iVendorService.getAllObject();
        return new ResponseEntity<List<Vendor>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/vendorlist", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody Vendor vendor, UriComponentsBuilder builder) {
        boolean flag = iVendorService.addObject(vendor);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/vendorlist/{id}").buildAndExpand(vendor.getVendorId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/vendorlist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Vendor> updateVendor(@RequestBody Vendor vendor) {
        iVendorService.updateObject(vendor);
        return new ResponseEntity<Vendor>(vendor, HttpStatus.OK);
    }

    @RequestMapping(value = "/vendorlist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        iVendorService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
