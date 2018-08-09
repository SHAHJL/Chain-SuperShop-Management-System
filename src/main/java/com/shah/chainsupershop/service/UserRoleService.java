/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.service;

import com.shah.chainsupershop.dao.IUserRoleDAO;
import com.shah.chainsupershop.domain.UserRole;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author R-34
 */
@Service
public class UserRoleService implements IUserRoleService{

    @Autowired
    private IUserRoleDAO iUserRoleDAO;
    
    @Override
    public List<UserRole> getAllObject() {
        return iUserRoleDAO.getAllObject();
    }

    @Override
    public UserRole getObjectById(int id) {
        UserRole obj = iUserRoleDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(UserRole obj) {
        if (iUserRoleDAO.objectExists(obj.getRoleName())) {
            return false;
        } else {
            iUserRoleDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(UserRole obj) {
        iUserRoleDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iUserRoleDAO.deleteObject(id);
    }
    
}
