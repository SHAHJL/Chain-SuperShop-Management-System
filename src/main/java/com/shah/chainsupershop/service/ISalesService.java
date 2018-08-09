/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.service;

import com.shah.chainsupershop.domain.Sales;
import java.util.List;

/**
 *
 * @author R-34
 */
public interface ISalesService {
    
    List<Sales> getAllObject();

    Sales getObjectById(int id);

    void addObject(Sales obj);

    void updateObject(Sales obj);

    void deleteObject(int id);
}
