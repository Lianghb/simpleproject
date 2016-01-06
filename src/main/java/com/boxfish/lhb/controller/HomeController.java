package com.boxfish.lhb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestOperations;

import java.security.Principal;

/**
 * Created by boxfish on 15/12/21.
 */
@Controller
public class HomeController {

//    @Autowired
//    RestOperations restOperations;
//
//    @ResponseBody
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public Object home(Principal principal) {
//        String username = principal.getName();
//        String result = restOperations.getForObject("http://localhost:8082/me", String.class);
//        return String.format("Hello, %s\nresult from server : %s", username, result);
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object index() {
        return "index";
    }

}
