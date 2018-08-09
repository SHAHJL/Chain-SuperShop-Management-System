/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.service;

import com.shah.chainsupershop.dao.ICategoryDAO;
import com.shah.chainsupershop.domain.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author R-34
 */@Service
public class CategoryService implements ICategoryService{

     @Autowired
     private ICategoryDAO iCategoryDAO;
     
    @Override
    public List<Category> getAllObject() {
        return iCategoryDAO.getAllObject();
    }

    @Override
    public Category getObjectById(int id) {
        Category obj = iCategoryDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(Category obj) {
       if (iCategoryDAO.objectExists(obj.getCatName())) {
            return false;
        } else {
           iCategoryDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(Category obj) {
        iCategoryDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iCategoryDAO.deleteObject(id);
    }
    
}
