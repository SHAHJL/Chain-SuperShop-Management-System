package com.shah.chainsupershop.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shah.chainsupershop.domain.Branch;
import com.shah.chainsupershop.service.IBranchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author R-34
 */
@Controller
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private IBranchService iBranchService;

    @RequestMapping("/home")
    public String home() {
        return "branch";
    }

    @RequestMapping(value = "/branchlist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<Branch>> getAllBranch() {
        List<Branch> list = iBranchService.getAllBranch();
        return new ResponseEntity<List<Branch>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/branchlist/{id}", method = RequestMethod.GET)
    public ResponseEntity<Branch> getBranchById(@PathVariable("id") Integer id) {
        Branch branch = iBranchService.getBranchById(id);
        return new ResponseEntity<Branch>(branch, HttpStatus.OK);
    }

    @RequestMapping(value = "/branchlist", method = RequestMethod.POST)
    public ResponseEntity<Void> addBranch(@RequestBody Branch branch, UriComponentsBuilder builder) {
        boolean flag = iBranchService.addBranch(branch);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("branchlist/{id}").buildAndExpand(branch.getBranchRegId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/branchlist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Branch> updateBranch(@RequestBody Branch branch) {
        iBranchService.updateBranch(branch);
        return new ResponseEntity<Branch>(branch, HttpStatus.OK);
    }

    @RequestMapping(value = "/branchlist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Branch> deleteBranch(@PathVariable("id") Integer id) {
        iBranchService.deleteBranch(id);
        return new ResponseEntity<Branch>(HttpStatus.NO_CONTENT);
    }

}
