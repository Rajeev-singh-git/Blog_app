package com.codewithrajeev.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithrajeev.blog.entities.User;

public interface UserRepo extends JpaRepository<User , Integer> {

}
