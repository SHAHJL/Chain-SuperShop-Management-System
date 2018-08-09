/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.service;

import com.shah.chainsupershop.dao.IVendorDAO;
import com.shah.chainsupershop.domain.Vendor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SHAH
 */
@Service
public class VendorService implements IVendorService{

    @Autowired
    private IVendorDAO iVendorDAO;
    
    @Override
    public List<Vendor> getAllObject() {
        return iVendorDAO.getAllObject();
    }

    @Override
    public Vendor getObjectById(int id) {
        Vendor obj = iVendorDAO.getObjectById(id);
        return obj;
    }

    @Override
    public boolean addObject(Vendor obj) {
        if (iVendorDAO.objectExists(obj.getUser().getUserId(), obj.getVendorName())) {
            return false;
        } else {
            iVendorDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(Vendor obj) {
        iVendorDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iVendorDAO.deleteObject(id);
    }
    
}
