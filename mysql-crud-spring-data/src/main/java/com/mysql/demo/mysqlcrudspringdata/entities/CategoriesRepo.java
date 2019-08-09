package com.mysql.demo.mysqlcrudspringdata.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepo extends JpaRepository<Categories, Long> {
	Categories findByCategorieName(String catName);
}
