/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.service;

import com.shah.chainsupershop.dao.ISubCategoryDAO;
import com.shah.chainsupershop.domain.SubCategory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SHAH
 */
@Service
public class SubCategoryService implements ISubCategoryService{
@Autowired
private ISubCategoryDAO iSubCategoryDAO;

    @Override
    public List<SubCategory> getAllObject() {
        return iSubCategoryDAO.getAllObject();
    }

    @Override
    public SubCategory getObjectById(int id) {
        SubCategory obj = iSubCategoryDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(SubCategory obj) {
        if (iSubCategoryDAO.objectExists(obj.getCategory().getCatId(), obj.getSubCatName())) {
            return false;
        } else {
            iSubCategoryDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(SubCategory obj) {
        iSubCategoryDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iSubCategoryDAO.deleteObject(id);
    }
    
}
