/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.controller;

import com.shah.chainsupershop.domain.Distribution;
import com.shah.chainsupershop.service.IDistributionService;
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
@RequestMapping("/distribution")
public class DistributionController {

    @Autowired
    private IDistributionService iDistributionService;

    @RequestMapping("/home")
    public String home() {
        return "distribution";
    }

    @RequestMapping(value = "/distlist", method = RequestMethod.GET)
    public ResponseEntity<List<Distribution>> getAllDistribution() {
        List<Distribution> list = iDistributionService.getAllObject();
        return new ResponseEntity<List<Distribution>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/distlist/{id}", method = RequestMethod.GET)
    public ResponseEntity<Distribution> getObjectById(@PathVariable("id") Integer id) {
        Distribution distribution = iDistributionService.getObjectById(id);
        return new ResponseEntity<Distribution>(distribution, HttpStatus.OK);
    }

    @RequestMapping(value = "/distlist", method = RequestMethod.POST)
//    public ResponseEntity<Void> addObject(@RequestBody Distribution distribution, UriComponentsBuilder builder) {
//        boolean flag = iDistributionService.addObject(distribution);
//        if (flag == false) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/purlist/{id}").buildAndExpand(distribution.getPurchaseId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }

    public ResponseEntity<Distribution> addObject(@RequestBody Distribution distribution) {
        iDistributionService.addObject(distribution);
        return new ResponseEntity<Distribution>(distribution, HttpStatus.OK);
    }

    @RequestMapping(value = "/distlist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Distribution> updateDistribution(@RequestBody Distribution distribution) {
        iDistributionService.updateObject(distribution);
        return new ResponseEntity<Distribution>(distribution, HttpStatus.OK);
    }

    @RequestMapping(value = "/distlist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        iDistributionService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
