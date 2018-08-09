package com.shah.chainsupershop.controller;

import com.shah.chainsupershop.domain.User;
import com.shah.chainsupershop.service.IUserService;
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
@RequestMapping("/userinfo")
public class UserController {
    @Autowired
    private IUserService userService;
    
    @RequestMapping("/home")
    public String home(){
    return "userinfo";
    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getObjectById(@PathVariable("id") Integer id) {
        User user = userService.getObjectById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    
     @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUser() {
        List<User> list = userService.getAllObject();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }
    
     @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody User user, UriComponentsBuilder builder) {
        boolean flag = userService.addObject(user);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
//    
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<User> updateObject(@RequestBody User userRole) {
//        userService.updateObject(userRole);
//        return new ResponseEntity<User>(userRole, HttpStatus.OK);
//    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.updateObject(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

     @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        userService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    
}
