/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.dao;

import com.shah.chainsupershop.domain.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SHAH
 */
@Transactional
@Repository
public class CustomerDAO implements ICustomerDAO{

    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    @SuppressWarnings("unchecked")
    
    @Override
    public List<Customer> getAllObject() {
        String hql = "FROM Customer as c ORDER BY c.customerId";
        return (List<Customer>) hibernateTemplate.find(hql);
    }

    @Override
    public Customer getObjectById(int id) {
        return hibernateTemplate.get(Customer.class, id);
    }

    @Override
    public void addObject(Customer obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(Customer obj) {
        Customer c = getObjectById(obj.getCustomerId());
        c.setCustomerName(obj.getCustomerName());
        c.setCustomerAddress(obj.getCustomerAddress());
        c.setCustomerEmail(obj.getCustomerEmail());
        c.setCustomerPhone(obj.getCustomerPhone());
        c.setOrderDate(obj.getOrderDate());
        hibernateTemplate.update(c);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(String custName) {
        String hql = "FROM Customer as p WHERE p.customerName=?";
        List<Customer> lst = (List<Customer>) hibernateTemplate.find(hql, custName);
        return lst.size() > 0 ? true : false;
    }
    
}
