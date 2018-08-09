/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.controller;

import com.shah.chainsupershop.domain.UserRole;
import com.shah.chainsupershop.service.IUserRoleService;
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
@RequestMapping("/roleinfo")
public class UserRoleController {
    
    @Autowired
    private IUserRoleService iUserRoleService;
    
    @RequestMapping("/home")
    public String home() {
        return "userinfo";
    }
    
    
    @RequestMapping(value = "/userrole/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserRole> getObjectById(@PathVariable("id") Integer id) {
        UserRole person = iUserRoleService.getObjectById(id);
        return new ResponseEntity<UserRole>(person, HttpStatus.OK);
    }

    @RequestMapping(value = "/userrole", method = RequestMethod.GET)
    public ResponseEntity<List<UserRole>> getAllUserRole() {
        List<UserRole> list = iUserRoleService.getAllObject();
        return new ResponseEntity<List<UserRole>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/userrole", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody UserRole userrole, UriComponentsBuilder builder) {
        boolean flag = iUserRoleService.addObject(userrole);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/userrole/{id}").buildAndExpand(userrole.getRoleId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/userrole/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserRole> updateUserRole(@RequestBody UserRole userrole) {
        iUserRoleService.updateObject(userrole);
        return new ResponseEntity<UserRole>(userrole, HttpStatus.OK);
    }

    @RequestMapping(value = "/userrole/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        iUserRoleService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    
}
