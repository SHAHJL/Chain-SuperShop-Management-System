package com.shah.chainsupershop.dao;

import com.shah.chainsupershop.domain.User;
import java.util.List;

/**
 *
 * @author R-34
 */
public interface IUserDAO {

    List<User> getAllObject();

    User getObjectById(int id);

    void addObject(User obj);

    void updateObject(User obj);

    void deleteObject(int id);

    boolean objectExists(int roleId, String firstName, String email);
}
