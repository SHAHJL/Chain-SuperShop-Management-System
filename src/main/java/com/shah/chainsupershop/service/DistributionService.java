/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.service;

import com.shah.chainsupershop.dao.IDistributionDAO;
import com.shah.chainsupershop.domain.Distribution;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author R-34
 */
@Service
public class DistributionService implements IDistributionService{
    
    @Autowired
    private IDistributionDAO iDistributionDAO;

    @Override
    public List<Distribution> getAllObject() {
        return iDistributionDAO.getAllObject();
    }

    @Override
    public Distribution getObjectById(int id) {
      Distribution obj = iDistributionDAO.getObjectById(id);
      return obj;
    }

    @Override
    public void addObject(Distribution obj) {
       iDistributionDAO.addObject(obj);
    }

    @Override
    public void updateObject(Distribution obj) {
       iDistributionDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iDistributionDAO.deleteObject(id);
    }
}
