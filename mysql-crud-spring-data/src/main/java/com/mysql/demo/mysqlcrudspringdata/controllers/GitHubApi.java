package com.mysql.demo.mysqlcrudspringdata.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.demo.mysqlcrudspringdata.entities.Article;
import com.mysql.demo.mysqlcrudspringdata.repositories.ArticleRepo;
import com.mysql.demo.mysqlcrudspringdata.repositories.AuthorRepo;
import com.mysql.demo.mysqlcrudspringdata.repositories.CategoriesRepo;
import com.mysql.demo.mysqlcrudspringdata.scrapper.GitHubScrapper;

@RestController
@RequestMapping("/api")
public class GitHubApi {
	
	@Autowired
	ArticleRepo articleRepo;
	
	@Autowired
	AuthorRepo authorRepo;
	
	@Autowired
	CategoriesRepo categoriesRepo;
	
	@GetMapping("/{userId}/{blogUrl}")
	public void saveArticle(@PathVariable("userId") String userId, @PathVariable("blogUrl") String blogUrl) {
		String url = "/"+userId+"/"+blogUrl;
		int noOfArticle = articleRepo.countByPostUrl(url);
		if(noOfArticle == 0) {
			Article article = new Article();
			article.setPostUrl(url);
			
		}
	}
	
	

}
