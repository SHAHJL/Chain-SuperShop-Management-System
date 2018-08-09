/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.dao;

import com.shah.chainsupershop.domain.Vendor;
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
public class VendorDAO implements IVendorDAO{

    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    @Override
    public List<Vendor> getAllObject() {
        String hql = "FROM Vendor p LEFT JOIN FETCH  p.user ORDER BY p.vendorId";
        return (List<Vendor>) hibernateTemplate.find(hql);
    }

    @Override
    public Vendor getObjectById(int id) {
        return hibernateTemplate.get(Vendor.class, id);
        
    }

    @Override
    public void addObject(Vendor obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(Vendor obj) {
        Vendor v = getObjectById(obj.getVendorId());
        v.setUser(obj.getUser());
        v.setVendorName(obj.getVendorName());
        v.setVendorLocation(obj.getVendorLocation());
        v.setVendorType(obj.getVendorType());
        hibernateTemplate.update(v);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(id);
    }

    @Override
    public boolean objectExists(int userid, String vname) {
        String hql = "FROM Vendor as p WHERE p.user.userId = ? and p.vendorName= ?";
        List<Vendor> lst = (List<Vendor>) hibernateTemplate.find(hql, userid, vname);
        return lst.size() > 0 ? true : false;
    }
    
}
