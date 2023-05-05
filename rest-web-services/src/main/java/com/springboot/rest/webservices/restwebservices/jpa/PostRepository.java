package com.springboot.rest.webservices.restwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.webservices.restwebservices.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
