package com.shah.chainsupershop.service;

import com.shah.chainsupershop.dao.IUserDAO;
import com.shah.chainsupershop.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author R-34
 */
@Service
public class UserService implements IUserService{

    @Autowired
    private IUserDAO iUserDAO;
    
    @Override
    public List<User> getAllObject() {
        return iUserDAO.getAllObject();
    }

    @Override
    public User getObjectById(int id) {
        User obj =iUserDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(User obj) {
        if (iUserDAO.objectExists(obj.getUserRole().getRoleId(), obj.getFirstName(), obj.getEmail())) {
            return false;
        } else {
            iUserDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(User obj) {
        iUserDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
       iUserDAO.deleteObject(id);
    }
    
}
