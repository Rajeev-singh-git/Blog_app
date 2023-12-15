package com.codewithrajeev.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithrajeev.blog.entities.Category;


public interface CategoryRepo extends JpaRepository<Category, Integer> {

	

}