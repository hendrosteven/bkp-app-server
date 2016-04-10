/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkn.repo;

import com.bkn.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author hendro.tampake
 */
public interface UsersRepo extends PagingAndSortingRepository<Users, String> {

    @Query("select u from Users u where u.email = ?1")
    public Users findByEmail(String email);

    @Query("select u from Users u where u.email = ?1 and u.password = ?2")
    public Users findByEmailAndPassword(String email, String password);
}
