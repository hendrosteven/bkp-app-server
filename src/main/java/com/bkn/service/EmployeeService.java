/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkn.service;

import com.bkn.dto.ResponseData;
import com.bkn.dto.ResponseObject;
import com.bkn.entity.Employee;
import com.bkn.repo.EmployeeRepo;
import com.bkn.repo.UsersRepo;
import java.util.Collection;
import javax.transaction.Transactional;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author hendro.tampake
 */
@Service("employeeService")
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepo empRepo;
    @Autowired
    private UsersRepo userRepo;

    private static final int PAGE_SIZE = 10;

    public ResponseObject register(Employee emp, String userId) {
        emp.setInputBy(userRepo.findOne(userId));
        return new ResponseObject(true, "Employee saved", new ResponseData(1, empRepo.save(emp)));
    }

    public ResponseObject findAll(String userId, int pageNumber) {
        //Collection<Employee> list = IteratorUtils.toList(empRepo.findByAll(userId).iterator());
        PageRequest pageRequest = new PageRequest(pageNumber - 1, PAGE_SIZE);
        Collection<Employee> list = IteratorUtils.toList(empRepo.findByAll(userId, pageRequest).iterator());
        return new ResponseObject(true, "Employee List", new ResponseData(list.size(), list));
    }

    public ResponseObject findByName(String name, String userId) {
        Collection<Employee> list = IteratorUtils.toList(empRepo.findByName(name, userId).iterator());
        return new ResponseObject(true, "Employee List By Name", new ResponseData(list.size(), list));
    }

    public ResponseObject findById(String id, String userId) {
        return new ResponseObject(true, "Employee List By Id", new ResponseData(1, empRepo.findById(id, userId)));
    }
}
