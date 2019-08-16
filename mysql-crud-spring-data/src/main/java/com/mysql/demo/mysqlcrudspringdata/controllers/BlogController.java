package com.mysql.demo.mysqlcrudspringdata.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.demo.mysqlcrudspringdata.entities.Article;
import com.mysql.demo.mysqlcrudspringdata.entities.Author;
import com.mysql.demo.mysqlcrudspringdata.entities.Categories;
import com.mysql.demo.mysqlcrudspringdata.models.BlogData;
import com.mysql.demo.mysqlcrudspringdata.repositories.ArticleRepo;
import com.mysql.demo.mysqlcrudspringdata.repositories.AuthorRepo;
import com.mysql.demo.mysqlcrudspringdata.repositories.CategoriesRepo;

@RestController
@RequestMapping("/post")
public class BlogController {
	
	@Autowired
	ArticleRepo articleRepo;
	
	@Autowired
	AuthorRepo authorRepo;
	
	@Autowired
	CategoriesRepo catRepo;
	
	@GetMapping("/posts/{catname}")
	public List<Article> getPosts(@PathVariable("catname") String catname){
		return articleRepo.findByCategories_CategorieName(catname);
	}
	
	@GetMapping("/post/{authId}")
	public List<Article> getPostByAuthor(@PathVariable("authId") long authorId){
		return articleRepo.findByAuthor_AuthorId(authorId);
	}
	
	@GetMapping("/post-by-cat/{catid}")
	public List<Article> getPosts(@PathVariable("catid") long catid){
		return articleRepo.findByCategories_CategorieId(catid);
	}
	
	@PostMapping("/add-post")
	public Article savePost(@RequestBody BlogData data) {
		
		Article article = new Article();
		article.setPostContributer(data.getPostContributer());
		article.setPostDescription(data.getPostDescription());
		article.setPostFork(data.getPostFork());
		article.setPostReadme(data.getPostReadme());
		article.setPostReadMeText(data.getPostReadMeText());
		article.setPostStar(data.getPostStar());
		article.setPostTitle(data.getPostTitle());
		article.setPostUrl(data.getPostUrl());
		article.setPostWatch(data.getPostWatch());
		
		if(data.getAuthor().getAuthorId() != 0L) {
			Author author = authorRepo.getOne(data.getAuthor().getAuthorId());
			if(author != null) {
				article.setAuthor(author);
			}
		}
		else {
			Author author  = new Author();
			author.setAuthorName(data.getAuthor().getAuthorName());
			authorRepo.save(author);
			
			article.setAuthor(author);
		}
		List<Categories> catList = new ArrayList<>();
		
		for(String cat : data.getCategoryName()) {
			Categories c = catRepo.findByCategorieName(cat);
			if(c == null) {
				Categories category = new Categories();
				category.setCategorieName(cat);
				catList.add(catRepo.save(category));
			}
			else
			catList.add(c);
		}
		
		article.setCategories(catList);
		
		
		articleRepo.save(article);
		
		
		return article;
	}
	
	@PostMapping("/add-author")
	public Author saveAuthor(@RequestBody Author author) {
		return authorRepo.save(author);
	}
	
	@PostMapping("/add-categories")
	public Categories saveCategory(@RequestBody Categories category) {
		return catRepo.save(category);
	}

}
