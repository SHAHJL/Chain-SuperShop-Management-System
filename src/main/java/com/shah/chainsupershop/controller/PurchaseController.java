/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.controller;

import com.shah.chainsupershop.domain.Purchase;
import com.shah.chainsupershop.service.IPurchaseService;
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
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private IPurchaseService iPurchaseService;
    
   
    @RequestMapping("/home")
    public String home() {
        return "purchase";
    }
    @RequestMapping(value = "/purlist", method = RequestMethod.GET)
    public ResponseEntity<List<Purchase>> getAllPurchase() {
        List<Purchase> list = iPurchaseService.getAllObject();
        return new ResponseEntity<List<Purchase>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/purlist/{id}", method = RequestMethod.GET)
    public ResponseEntity<Purchase> getObjectById(@PathVariable("id") Integer id) {
        Purchase purchase = iPurchaseService.getObjectById(id);
        return new ResponseEntity<Purchase>(purchase, HttpStatus.OK);
    }

    @RequestMapping(value = "/purlist", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody Purchase purchase, UriComponentsBuilder builder) {
        boolean flag = iPurchaseService.addObject(purchase);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/purlist/{id}").buildAndExpand(purchase.getPurId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

//    @RequestMapping(value = "/purlist", method = RequestMethod.POST)
//    public ResponseEntity<Purchase> addObject(@RequestBody Purchase purchase) {
//       iPurchaseService.addObject(purchase);
//        return new ResponseEntity<Purchase>(purchase, HttpStatus.CREATED);
//    }

    @RequestMapping(value = "/purlist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Purchase> updatePurchase(@RequestBody Purchase purchase) {
        iPurchaseService.updateObject(purchase);
        return new ResponseEntity<Purchase>(purchase, HttpStatus.OK);
    }

    @RequestMapping(value = "/purlist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        iPurchaseService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
