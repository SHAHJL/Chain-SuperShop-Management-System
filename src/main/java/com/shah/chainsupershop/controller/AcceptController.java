/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.controller;

import com.shah.chainsupershop.domain.Accept;
import com.shah.chainsupershop.service.IAcceptService;
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
@RequestMapping("/accept")
public class AcceptController {
    
    @Autowired
    private IAcceptService iAcceptService;
  
    @RequestMapping("/home")
    public String home() {
        return "accept";
    }
    @RequestMapping(value = "/acceptlist", method = RequestMethod.GET)
    public ResponseEntity<List<Accept>> getAllAccept() {
        List<Accept> list = iAcceptService.getAllObject();
        return new ResponseEntity<List<Accept>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/acceptlist/{id}", method = RequestMethod.GET)
    public ResponseEntity<Accept> getObjectById(@PathVariable("id") Integer id) {
        Accept accept = iAcceptService.getObjectById(id);
        return new ResponseEntity<Accept>(accept, HttpStatus.OK);
    }

    @RequestMapping(value = "/acceptlist", method = RequestMethod.POST)
//    public ResponseEntity<Void> addObject(@RequestBody Accept accept, UriComponentsBuilder builder) {
//        boolean flag = iAcceptService.addObject(accept);
//        if (flag == false) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/acceptlist/{id}").buildAndExpand(accept.getAccId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
    
    public ResponseEntity<Accept> addObject(@RequestBody Accept accept) {
        iAcceptService.addObject(accept);
        return new ResponseEntity<Accept>(accept, HttpStatus.OK);
    }

    @RequestMapping(value = "/acceptlist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Accept> updateAccept(@RequestBody Accept accept) {
        iAcceptService.updateObject(accept);
        return new ResponseEntity<Accept>(accept, HttpStatus.OK);
    }

    @RequestMapping(value = "/acceptlist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        iAcceptService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
