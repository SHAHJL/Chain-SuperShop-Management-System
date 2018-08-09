/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.dao;

import com.shah.chainsupershop.domain.Purchase;
import java.util.Date;
import java.util.List;

/**
 *
 * @author R-34
 */
public interface IPurchaseDAO {
    
    List<Purchase> getAllObject();

    Purchase getObjectById(int id);

    void addObject(Purchase obj);

    void updateObject(Purchase obj);

    void deleteObject(int id);

    boolean objectExists(int catid, Date pdate);
}
