/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.dao;

import com.shah.chainsupershop.domain.Distribution;
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
public class DistributionDAO implements IDistributionDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Distribution> getAllObject() {
//        String hql = "FROM Distribution as c ORDER BY c.distId";
String hql= " FROM Distribution p LEFT JOIN FETCH  p.category LEFT JOIN FETCH p.subCategory LEFT JOIN FETCH p.product LEFT JOIN FETCH p.branch ORDER BY p.distId";
        return (List<Distribution>) hibernateTemplate.find(hql);
    }

    @Override
    public Distribution getObjectById(int id) {
        return hibernateTemplate.get(Distribution.class, id);
    }

    @Override
    public void addObject(Distribution obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(Distribution obj) {
        Distribution d = getObjectById(obj.getDistId());
        d.setBranch(obj.getBranch());
        d.setCategory(obj.getCategory());
        d.setSubCategory(obj.getSubCategory());
        d.setProduct(obj.getProduct());
        d.setDistDate(obj.getDistDate());
        d.setDistQty(obj.getDistQty());
        d.setTotalAmount(obj.getTotalAmount());
        d.setDistStatus(obj.getDistStatus());
        hibernateTemplate.update(d);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

//    @Override
//    public boolean objectExists(Date disdate) {
//        String hql = "FROM Distribution as p WHERE p.distributionDate=?";
//        List<Distribution> lst = (List<Distribution>) hibernateTemplate.find(hql, disdate);
//        return lst.size() > 0 ? true : false;
//    }
}
