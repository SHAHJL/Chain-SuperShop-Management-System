package com.shah.chainsupershop.dao;

import com.shah.chainsupershop.domain.Branch;
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
public class BranchDAO implements IBranchDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Branch> getAllBranch() {
//        String hql = "FROM Branch b ORDER BY b.branchRegId";
        String hql = "FROM Branch b LEFT JOIN FETCH  b.user ORDER BY b.branchRegId";
        return (List<Branch>) hibernateTemplate.find(hql);
    }

    @Override
    public Branch getBranchById(int branchRegId) {
        return hibernateTemplate.get(Branch.class, branchRegId);
    }

    @Override
    public void addBranch(Branch branch) {
        hibernateTemplate.save(branch);
    }

    @Override
    public void updateBranch(Branch branch) {
        Branch b = getBranchById(branch.getBranchRegId());
        b.setUser(branch.getUser());
        b.setDistributions(branch.getDistributions());
        b.setAccepts(branch.getAccepts());
        b.setSaleses(branch.getSaleses());
        b.setBranchName(branch.getBranchName());
        b.setBranchLocation(branch.getBranchLocation());
        hibernateTemplate.update(b);
    }

    @Override
    public void deleteBranch(int branchRegId) {
        hibernateTemplate.delete(getBranchById(branchRegId));
    }

    @Override
    public boolean branchExists(int userId, String branchName) {

        String hql = "FROM Branch as b WHERE b.user.userId = ? and b.branchName = ?";
        List<Branch> branchList = (List<Branch>) hibernateTemplate.find(hql, userId, branchName);
        return branchList.size() > 0 ? true : false;

//        String hql = "FROM TspInfo as p WHERE p.tspName = ? and p.tspLocation = ?";
//        List<TspInfo> tspList = (List<TspInfo>) hibernateTemplate.find(hql, name, location);
//        return tspList.size() > 0 ? true : false;
    }

}
