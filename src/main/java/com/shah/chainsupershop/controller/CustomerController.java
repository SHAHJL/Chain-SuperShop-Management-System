/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.controller;

import com.shah.chainsupershop.domain.Customer;
import com.shah.chainsupershop.service.ICustomerService;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    
    
    @RequestMapping("/home")
    public String home() {
        return "customer";
    }
    @RequestMapping(value = "/custlist", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> list = iCustomerService.getAllObject();
        return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/custlist/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> getObjectById(@PathVariable("id") Integer id) {
        Customer customer = iCustomerService.getObjectById(id);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/custlist", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody Customer customer, UriComponentsBuilder builder) {
        boolean flag = iCustomerService.addObject(customer);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/custlist/{id}").buildAndExpand(customer.getCustomerId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/custlist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        iCustomerService.updateObject(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/custlist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        iCustomerService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
