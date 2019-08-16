package com.mysql.demo.mysqlcrudspringdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysql.demo.mysqlcrudspringdata.entities.Article;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Long> {
	List<Article> findByCategories_CategorieName(String catName);
	List<Article> findByCategories_CategorieId(long id);
	List<Article> findByAuthor_AuthorId(long authorId);
	int countByPostUrl(String postUrl);
}
