/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.service;

import com.shah.chainsupershop.dao.IAcceptDAO;
import com.shah.chainsupershop.domain.Accept;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author R-34
 */
@Service
public class AcceptService implements IAcceptService{
    
    @Autowired
    private IAcceptDAO iAcceptDAO;

    @Override
    public List<Accept> getAllObject() {
        return iAcceptDAO.getAllObject();
    }

    @Override
    public Accept getObjectById(int id) {
        Accept obj = iAcceptDAO.getObjectById(id);
        return obj;
    }

    @Override
    public void addObject(Accept obj) {
        iAcceptDAO.addObject(obj);
    }

    @Override
    public void updateObject(Accept obj) {
        iAcceptDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
       iAcceptDAO.deleteObject(id);
    }
    
}
