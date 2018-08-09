/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.dao;

import com.shah.chainsupershop.domain.Purchase;
import java.util.Date;
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
public class PurchaseDAO implements IPurchaseDAO{
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Purchase> getAllObject() {
//         String hql = "FROM Purchase as c ORDER BY c.purId";
String hql= " FROM Purchase p LEFT JOIN FETCH  p.category LEFT JOIN FETCH p.subCategory LEFT JOIN FETCH p.product LEFT JOIN FETCH p.vendor ORDER BY p.purId";
        return (List<Purchase>) hibernateTemplate.find(hql);
    }

    @Override
    public Purchase getObjectById(int id) {
        return hibernateTemplate.get(Purchase.class, id);
    }

    @Override
    public void addObject(Purchase obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(Purchase obj) {
       Purchase p = getObjectById(obj.getPurId());
       p.setCategory(obj.getCategory());
       p.setSubCategory(obj.getSubCategory());
       p.setProduct(obj.getProduct());
       p.setVendor(obj.getVendor());
       p.setPurDate(obj.getPurDate());
       p.setPurPrice(obj.getPurPrice());
       p.setPurQty(obj.getPurQty());
       p.setPurDesc(obj.getPurDesc());
       hibernateTemplate.update(p);
    }

    @Override
    public void deleteObject(int id) {
       hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(int catid, Date pdate) {
       String hql = "FROM Purchase as p WHERE p.category.catId = ? and p.purDate = ?";
        List<Purchase> lst = (List<Purchase>) hibernateTemplate.find(hql, catid, pdate);
        return lst.size() > 0 ? true : false;
    }
    
}
