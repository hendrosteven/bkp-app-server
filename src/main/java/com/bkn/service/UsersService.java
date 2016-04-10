/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkn.service;

import com.bkn.dto.ResponseData;
import com.bkn.dto.ResponseObject;
import com.bkn.entity.Users;
import com.bkn.repo.UsersRepo;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hendro.tampake
 */
@Service("userService")
@Transactional
public class UsersService {

    @Autowired
    private UsersRepo userRepo;

    public ResponseObject findByEmail(String email) {
        Users users = userRepo.findByEmail(email);
        if (users != null) {
            return new ResponseObject(true, "Users By Email", new ResponseData(1, users));
        } else {
            return new ResponseObject(false, "Users By Email Not Found", null);
        }
    }

    public ResponseObject findByEmailAndPassword(String email, String password) {
        Users users = userRepo.findByEmailAndPassword(email, password);
        if (users != null) {
            return new ResponseObject(true, "Users By Email and Password", new ResponseData(1, users));
        } else {
            return new ResponseObject(false, "Users Not Found", null);
        }
    }

    public ResponseObject findById(String id) {
        Users users = userRepo.findOne(id);
        if (users != null) {
            return new ResponseObject(true, "Users By ID", new ResponseData(1, users));
        } else {
            return new ResponseObject(false, "Users By ID Not Found", null);
        }
    }

    public ResponseObject register(Users users) {
        if (userRepo.findByEmail(users.getEmail()) == null) {            
            Users savedUsers = userRepo.save(users);
            return new ResponseObject(true, "Users saved", new ResponseData(1, savedUsers));
        } else {
            return new ResponseObject(false, "Please used other email, this email has been registered", null);
        }
    }

    public ResponseObject update(Users users) {
        Users savedUsers = userRepo.save(users);
        return new ResponseObject(true, "Users updated", new ResponseData(1, savedUsers));
    }

}
