/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.service;

import com.shah.chainsupershop.domain.Product;
import java.util.List;

/**
 *
 * @author SHAH
 */
public interface IProductService {
    
     List<Product> getAllObject();

    Product getObjectById(int id);

    boolean addObject(Product obj);

    void updateObject(Product obj);

    void deleteObject(int id);
}
