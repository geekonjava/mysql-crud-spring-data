package com.mysql.demo.mysqlcrudspringdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysql.demo.mysqlcrudspringdata.entities.Categories;

@Repository
public interface CategoriesRepo extends JpaRepository<Categories, Long> {
	Categories findByCategorieName(String catName);
}
