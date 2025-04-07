package com.learn.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
