/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.service;

import com.shah.chainsupershop.domain.Customer;
import java.util.List;

/**
 *
 * @author SHAH
 */
public interface ICustomerService {
    
    List<Customer> getAllObject();

    Customer getObjectById(int id);

    boolean addObject(Customer obj);

    void updateObject(Customer obj);

    void deleteObject(int id);
}
