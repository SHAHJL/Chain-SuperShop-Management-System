/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.service;

import com.shah.chainsupershop.dao.ISalesDAO;
import com.shah.chainsupershop.domain.Sales;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author R-34
 */
@Service
public class SalesService implements ISalesService{

    @Autowired
    private ISalesDAO iSalesDAO;
    
    @Override
    public List<Sales> getAllObject() {
        return iSalesDAO.getAllObject();
    }

    @Override
    public Sales getObjectById(int id) {
       Sales obj = iSalesDAO.getObjectById(id);
       return obj;
    }

    @Override
    public void addObject(Sales obj) {
        iSalesDAO.addObject(obj);
    }

    @Override
    public void updateObject(Sales obj) {
        iSalesDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iSalesDAO.deleteObject(id);
    }
    
}
