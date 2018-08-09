/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.dao;

import com.shah.chainsupershop.domain.UserRole;
import java.util.List;

/**
 *
 * @author R-34
 */
public interface IUserRoleDAO {
    
    List<UserRole> getAllObject();

    UserRole getObjectById(int id);

    void addObject(UserRole obj);

    void updateObject(UserRole obj);

    void deleteObject(int id);

    boolean objectExists(String roleName);
}
