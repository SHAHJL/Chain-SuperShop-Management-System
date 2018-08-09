/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.service;

import com.shah.chainsupershop.domain.SubCategory;
import java.util.List;

/**
 *
 * @author SHAH
 */
public interface ISubCategoryService {
    
    List<SubCategory> getAllObject();

    SubCategory getObjectById(int id);

    boolean addObject(SubCategory obj);

    void updateObject(SubCategory obj);

    void deleteObject(int id);
}
