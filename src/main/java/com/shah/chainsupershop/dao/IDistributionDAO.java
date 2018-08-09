/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.dao;

import com.shah.chainsupershop.domain.Distribution;
import java.util.List;

/**
 *
 * @author R-34
 */
public interface IDistributionDAO {
    
    List<Distribution> getAllObject();

    Distribution getObjectById(int id);

    void addObject(Distribution obj);

    void updateObject(Distribution obj);

    void deleteObject(int id);

//    boolean objectExists(Date disdate);
}
