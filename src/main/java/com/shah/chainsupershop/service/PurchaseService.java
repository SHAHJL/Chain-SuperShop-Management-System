/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.service;

import com.shah.chainsupershop.dao.IPurchaseDAO;
import com.shah.chainsupershop.domain.Purchase;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author R-34
 */@Service
public class PurchaseService implements IPurchaseService{
    @Autowired
    private IPurchaseDAO iPurchaseDAO;

    @Override
    public List<Purchase> getAllObject() {
        return iPurchaseDAO.getAllObject();
    }

    @Override
    public Purchase getObjectById(int id) {
        Purchase p = iPurchaseDAO.getObjectById(id);
        return p;
    }

    @Override
    public boolean addObject(Purchase obj) {
        if (iPurchaseDAO.objectExists(obj.getCategory().getCatId(), obj.getPurDate())) {
            return false;
        } else {
            iPurchaseDAO.addObject(obj);
            return true;
        }
    }
//    @Override
//    public void addObject(Purchase obj) {
//       iPurchaseDAO.addObject(obj);
//    }

    @Override
    public void updateObject(Purchase obj) {
        iPurchaseDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iPurchaseDAO.deleteObject(id);
    }
    
}
