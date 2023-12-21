package com.codewithrajeev.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithrajeev.blog.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{

}
