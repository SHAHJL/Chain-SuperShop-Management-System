/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.service;

import com.shah.chainsupershop.domain.Category;
import java.util.List;

/**
 *
 * @author R-34
 */
public interface ICategoryService {
    
    List<Category> getAllObject();

    Category getObjectById(int id);

    boolean addObject(Category obj);

    void updateObject(Category obj);

    void deleteObject(int id);
}
