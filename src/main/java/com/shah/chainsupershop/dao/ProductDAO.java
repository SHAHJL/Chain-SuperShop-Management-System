/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.dao;

import com.shah.chainsupershop.domain.Product;
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
public class ProductDAO implements IProductDAO{

    @Autowired
    private HibernateTemplate hibernateTemplate;

//    @SuppressWarnings("unchecked")

    @Override
    public List<Product> getAllObject() {
        
//        String hql = "FROM BookList p LEFT JOIN FETCH  p.author LEFT JOIN FETCH  p.category LEFT JOIN FETCH  p.publisher LEFT JOIN FETCH  p.subCategory ORDER BY p.bookId";

        String hql = "FROM Product p LEFT JOIN FETCH  p.category LEFT JOIN FETCH  p.subCategory ORDER BY p.productId";
        return (List<Product>) hibernateTemplate.find(hql);
    }

    @Override
    public Product getObjectById(int id) {
        return hibernateTemplate.get(Product.class, id);
    }

    @Override
    public void addObject(Product obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(Product obj) {
        Product p = getObjectById(obj.getProductId());
        p.setCategory(obj.getCategory());
        p.setSubCategory(obj.getSubCategory());
        p.setProductName(obj.getProductName());
        p.setProductPrice(obj.getProductPrice());
        p.setProductQty(obj.getProductQty());
        p.setProductDesc(obj.getProductDesc());
        p.setImgPath(obj.getImgPath());
        hibernateTemplate.update(p);
    }

    @Override
    public void deleteObject(int id) {
       hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(int catId, int subCatId, String pname) {
         String hql = "FROM Product as p WHERE p.category.catId = ? and p.subCategory.subCatId = ? and p.productName = ?";
//         String hql = "FROM Product as p WHERE p.productName = ?";
        List<Product> lst = (List<Product>) hibernateTemplate.find(hql, catId, subCatId, pname);
        return lst.size() > 0 ? true : false;
    }
    
}
