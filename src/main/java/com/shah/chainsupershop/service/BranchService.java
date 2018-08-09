package com.shah.chainsupershop.service;

import com.shah.chainsupershop.dao.IBranchDAO;
import com.shah.chainsupershop.domain.Branch;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author R-34
 */
@Service
public class BranchService implements IBranchService{
    @Autowired
    private IBranchDAO iBranchDAO;

    @Override
    public List<Branch> getAllBranch() {
        return iBranchDAO.getAllBranch();
    }

    @Override
    public Branch getBranchById(int branchRegId) {
        Branch obj=iBranchDAO.getBranchById(branchRegId);
        return obj;
    }

    @Override
    public synchronized boolean addBranch(Branch branch) {
        if (iBranchDAO.branchExists(branch.getUser().getUserId(), branch.getBranchName())) {
            return false;
        } else {
            iBranchDAO.addBranch(branch);
            return true;
        }
    }

    @Override
    public void updateBranch(Branch branch) {
        iBranchDAO.updateBranch(branch);
    }

    @Override
    public void deleteBranch(int branchRegId) {
        iBranchDAO.deleteBranch(branchRegId);
    }
}
