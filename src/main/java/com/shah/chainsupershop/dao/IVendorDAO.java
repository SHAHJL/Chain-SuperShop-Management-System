/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.dao;

import com.shah.chainsupershop.domain.Vendor;
import java.util.List;

/**
 *
 * @author SHAH
 */
public interface IVendorDAO {
    
    List<Vendor> getAllObject();

    Vendor getObjectById(int id);

    void addObject(Vendor obj);

    void updateObject(Vendor obj);

    void deleteObject(int id);

    boolean objectExists(int userid, String vname);
}
