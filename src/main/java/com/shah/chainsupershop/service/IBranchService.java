package com.shah.chainsupershop.service;

import com.shah.chainsupershop.domain.Branch;
import java.util.List;

/**
 *
 * @author R-34
 */
public interface IBranchService {

    List<Branch> getAllBranch();

    Branch getBranchById(int branchRegId);

    boolean addBranch(Branch branch);

    void updateBranch(Branch branch);

    void deleteBranch(int branchRegId);
}
