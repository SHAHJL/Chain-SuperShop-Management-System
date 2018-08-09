package com.shah.chainsupershop.dao;

import com.shah.chainsupershop.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author R-34
 */
@Transactional
@Repository
public class UserDAO implements IUserDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<User> getAllObject() {
//        String hql = "FROM User as u, UserRole as i where u.userRole.roleId = i.roleId ORDER BY u.userId";
        String hql = "FROM User p LEFT JOIN FETCH  p.userRole ORDER BY p.userId";
        return (List<User>) hibernateTemplate.find(hql);
    }

    @Override
    public User getObjectById(int id) {
        return hibernateTemplate.get(User.class, id);
    }

    @Override
    public void addObject(User obj) {
       hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(User obj) {
        User u = getObjectById(obj.getUserId());
        u.setFirstName(obj.getFirstName());
        u.setLastName(obj.getLastName());
        u.setUserName(obj.getUserName());
        u.setUserPassword(obj.getUserPassword());
        u.setEmail(obj.getEmail());
        u.setPhone(obj.getPhone());
        u.setUserRole(obj.getUserRole());
//        u.setBranches(obj.getBranches());
//        u.setVendors(obj.getVendors());
       hibernateTemplate.update(u);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(int roleId, String firstName, String email) {
        String hql = "FROM User as u WHERE u.userRole.roleId = ? and u.firstName = ? and u.email = ?";
        List<User> lst = (List<User>) hibernateTemplate.find(hql, roleId, firstName, email);
        return lst.size() > 0 ? true : false;
    }

}
