/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.dao;

import com.shah.chainsupershop.domain.Customer;
import java.util.List;

/**
 *
 * @author SHAH
 */
public interface ICustomerDAO {
    
    List<Customer> getAllObject();

    Customer getObjectById(int id);

    void addObject(Customer obj);

    void updateObject(Customer obj);

    void deleteObject(int id);

    boolean objectExists(String custName);
}
