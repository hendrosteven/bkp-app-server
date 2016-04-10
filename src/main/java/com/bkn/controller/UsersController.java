/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkn.controller;

import com.bkn.dto.LoginObject;
import com.bkn.dto.ResponseObject;
import com.bkn.entity.Users;
import com.bkn.service.UsersService;
import java.util.concurrent.Callable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hendro.tampake
 */
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    private UsersService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Callable<ResponseObject> login(@RequestBody LoginObject login) {
        return new Callable<ResponseObject>() {
            @Override
            public ResponseObject call() throws Exception {
                return userService.findByEmailAndPassword(login.getEmail(), login.getPassword());
            }
        };
    }

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public Callable<ResponseObject> findByEmail(@RequestBody LoginObject login) {
        return new Callable<ResponseObject>() {
            @Override
            public ResponseObject call() throws Exception {
                return userService.findByEmail(login.getEmail());
            }
        };
    }

    @RequestMapping(method = RequestMethod.GET)
    public Callable<ResponseObject> findById() {
        return new Callable<ResponseObject>() {

            @Override
            public ResponseObject call() throws Exception {
                User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                return userService.findById(user.getUsername());
            }
        };
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public Callable<ResponseObject> register(@RequestBody Users users) {
        return new Callable<ResponseObject>() {

            @Override
            public ResponseObject call() throws Exception {
                return userService.register(users);
            }
        };

    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public Callable<ResponseObject> update(@RequestBody Users users) {
        return new Callable<ResponseObject>() {

            @Override
            public ResponseObject call() throws Exception {
                return userService.update(users);
            }
        };

    }
}
