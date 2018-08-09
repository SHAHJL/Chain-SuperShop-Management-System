/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.dao;

import com.shah.chainsupershop.domain.Category;
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
public class CategoryDAO implements ICategoryDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> getAllObject() {
        String hql = "FROM Category as c ORDER BY c.catId";
        return (List<Category>) hibernateTemplate.find(hql);
    }

    @Override
    public Category getObjectById(int id) {
        return hibernateTemplate.get(Category.class, id);
    }

    @Override
    public void addObject(Category obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(Category obj) {
        Category c = getObjectById(obj.getCatId());
        c.setCatName(obj.getCatName());
        c.setCatDesc(obj.getCatDesc());
        c.setImgPath(obj.getImgPath());
        hibernateTemplate.update(c);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(String catName) {
        String hql = "FROM Category as p WHERE p.catName=?";
        List<Category> lst = (List<Category>) hibernateTemplate.find(hql, catName);
        return lst.size() > 0 ? true : false;
    }

}
