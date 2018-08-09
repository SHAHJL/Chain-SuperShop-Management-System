/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.dao;

import com.shah.chainsupershop.domain.Sales;
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
public class SalesDAO implements ISalesDAO{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Sales> getAllObject() {
         String hql = "FROM Sales as c ORDER BY c.saleId";
        return (List<Sales>) hibernateTemplate.find(hql);
    }

    @Override
    public Sales getObjectById(int id) {
        return hibernateTemplate.get(Sales.class, id);
    }

    @Override
    public void addObject(Sales obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(Sales obj) {
        Sales s = getObjectById(obj.getSaleId());
        s.setBranch(obj.getBranch());
        s.setCustomer(obj.getCustomer());
        s.setSaleDate(obj.getSaleDate());
        s.setSalePrice(obj.getSalePrice());
        s.setSaleQty(obj.getSaleQty());
        s.setSaleDesc(obj.getSaleDesc());
        hibernateTemplate.update(s);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }
    
}
