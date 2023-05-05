package com.springboot.rest.webservices.restwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.webservices.restwebservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
