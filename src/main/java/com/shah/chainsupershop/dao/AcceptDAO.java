/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.dao;

import com.shah.chainsupershop.domain.Accept;
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
public class AcceptDAO implements IAcceptDAO{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Accept> getAllObject() {
//         String hql = "FROM Accept as c ORDER BY c.accId";
String hql= " FROM Accept p LEFT JOIN FETCH  p.category LEFT JOIN FETCH p.subCategory LEFT JOIN FETCH p.product LEFT JOIN FETCH p.branch ORDER BY p.accId";
        return (List<Accept>) hibernateTemplate.find(hql);
    }

    @Override
    public Accept getObjectById(int id) {
        return hibernateTemplate.get(Accept.class, id);
    }

    @Override
    public void addObject(Accept obj) {
       hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(Accept obj) {
       Accept a = getObjectById(obj.getAccId());
       a.setAccDate(obj.getAccDate());
       hibernateTemplate.update(a);
    }

    @Override
    public void deleteObject(int id) {
       hibernateTemplate.delete(getObjectById(id));
    }
    
}
