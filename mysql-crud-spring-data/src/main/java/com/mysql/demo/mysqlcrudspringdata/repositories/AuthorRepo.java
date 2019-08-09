package com.mysql.demo.mysqlcrudspringdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysql.demo.mysqlcrudspringdata.entities.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {

}
