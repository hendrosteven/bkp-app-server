/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkn.controller;

import com.bkn.dto.ResponseObject;
import com.bkn.entity.Employee;
import com.bkn.service.EmployeeService;
import java.util.concurrent.Callable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hendro.tampake
 */
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @RequestMapping(method = RequestMethod.GET, value = "/page/{page}")
    public Callable<ResponseObject> findAll(@PathVariable("page") int page) {
        return new Callable<ResponseObject>() {

            @Override
            public ResponseObject call() throws Exception {
                User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                return empService.findAll(user.getUsername(), page);
            }
        };
    }

    @RequestMapping(method = RequestMethod.POST)
    public Callable<ResponseObject> register(@RequestBody Employee emp) {
        return new Callable<ResponseObject>() {

            @Override
            public ResponseObject call() throws Exception {
                User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                return empService.register(emp, user.getUsername());
            }
        };
    }

    @RequestMapping(method = RequestMethod.GET, value = "/name/{name}")
    public Callable<ResponseObject> findByName(@PathVariable("name") String name) {
        return new Callable<ResponseObject>() {

            @Override
            public ResponseObject call() throws Exception {
                User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                return empService.findByName(name, user.getUsername());
            }
        };
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}")
    public Callable<ResponseObject> findById(@PathVariable("id") String id) {
        return new Callable<ResponseObject>() {

            @Override
            public ResponseObject call() throws Exception {
                User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                return empService.findById(id, user.getUsername());
            }
        };
    }

}
