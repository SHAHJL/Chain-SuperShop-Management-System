/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.service;

import com.shah.chainsupershop.domain.Vendor;
import java.util.List;

/**
 *
 * @author SHAH
 */
public interface IVendorService {
    
    List<Vendor> getAllObject();

    Vendor getObjectById(int id);

    boolean addObject(Vendor obj);

    void updateObject(Vendor obj);

    void deleteObject(int id);
}
