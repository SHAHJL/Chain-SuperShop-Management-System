package com.shah.chainsupershop.service;

import com.shah.chainsupershop.domain.User;
import java.util.List;

/**
 *
 * @author R-34
 */
public interface IUserService {
      List<User> getAllObject();

    User getObjectById(int id);

    boolean addObject(User obj);

    void updateObject(User obj);

    void deleteObject(int id);
}
