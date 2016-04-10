/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkn.repo;

import com.bkn.entity.Employee;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author hendro.tampake
 */
public interface EmployeeRepo extends PagingAndSortingRepository<Employee, String> {

    @Query("select e from Employee e where e.fullName like %?1% and e.inputBy.id = ?2")
    public List<Employee> findByName(String name, String userId);
    
    @Query("select e from Employee e where e.inputBy.id = ?1")
    public Page<Employee> findByAll(String userId, Pageable pageRequest);
    
    
    @Query("select e from Employee e where e.id = ?1 and e.inputBy.id = ?2")
    public Employee findById(String employeeId, String userId);
}
