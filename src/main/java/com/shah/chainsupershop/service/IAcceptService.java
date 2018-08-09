/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.service;

import com.shah.chainsupershop.domain.Accept;
import java.util.List;

/**
 *
 * @author R-34
 */
public interface IAcceptService {
    
    List<Accept> getAllObject();

    Accept getObjectById(int id);

    void addObject(Accept obj);

    void updateObject(Accept obj);

    void deleteObject(int id);
}
