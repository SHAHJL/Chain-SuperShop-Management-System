/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.service;

import com.shah.chainsupershop.dao.ICustomerDAO;
import com.shah.chainsupershop.domain.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SHAH
 */@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerDAO iCustomerDAO;

    @Override
    public List<Customer> getAllObject() {
        return iCustomerDAO.getAllObject();
    }

    @Override
    public Customer getObjectById(int id) {
        Customer obj = iCustomerDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(Customer obj) {
        if (iCustomerDAO.objectExists(obj.getCustomerName())) {
            return false;
        } else {
            iCustomerDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(Customer obj) {
        iCustomerDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iCustomerDAO.deleteObject(id);
    }
}