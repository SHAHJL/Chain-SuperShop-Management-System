/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.controller;

import com.shah.chainsupershop.domain.Sales;
import com.shah.chainsupershop.service.ISalesService;
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
@RequestMapping("/sales")
public class SalesController {
    
    @Autowired
    private ISalesService iSalesService;
    
  
    @RequestMapping("/home")
    public String home() {
        return "sales";
    }
    @RequestMapping(value = "/saleslist", method = RequestMethod.GET)
    public ResponseEntity<List<Sales>> getAllSales() {
        List<Sales> list = iSalesService.getAllObject();
        return new ResponseEntity<List<Sales>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/saleslist/{id}", method = RequestMethod.GET)
    public ResponseEntity<Sales> getObjectById(@PathVariable("id") Integer id) {
        Sales sales = iSalesService.getObjectById(id);
        return new ResponseEntity<Sales>(sales, HttpStatus.OK);
    }

    @RequestMapping(value = "/saleslist", method = RequestMethod.POST)
//    public ResponseEntity<Void> addObject(@RequestBody Sales sales, UriComponentsBuilder builder) {
//        boolean flag = iSalesService.addObject(sales);
//        if (flag == false) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/saleslist/{id}").buildAndExpand(sales.getPurchaseId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
    public ResponseEntity<Sales> addObject(@RequestBody Sales sales) {
        iSalesService.addObject(sales);
        return new ResponseEntity<Sales>(sales, HttpStatus.OK);
    }

    @RequestMapping(value = "/saleslist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Sales> updateSales(@RequestBody Sales sales) {
        iSalesService.updateObject(sales);
        return new ResponseEntity<Sales>(sales, HttpStatus.OK);
    }

    @RequestMapping(value = "/purlist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        iSalesService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
