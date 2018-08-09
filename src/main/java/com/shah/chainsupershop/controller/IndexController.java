package com.shah.chainsupershop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author R-34
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String welcome() {
        return "index";
    }
}
