package com.shah.chainsupershop.dao;

import com.shah.chainsupershop.domain.Branch;
import java.util.List;

/**
 *
 * @author R-34
 */
public interface IBranchDAO {

    List<Branch> getAllBranch();

    Branch getBranchById(int branchRegId);

    void addBranch(Branch branch);

    void updateBranch(Branch branch);

    void deleteBranch(int branchRegId);

    boolean branchExists(int userId, String branchName);
}
