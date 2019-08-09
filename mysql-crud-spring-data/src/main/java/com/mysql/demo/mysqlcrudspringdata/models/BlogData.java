package com.mysql.demo.mysqlcrudspringdata.models;

import java.util.List;

import com.mysql.demo.mysqlcrudspringdata.entities.Author;

import lombok.Data;

@Data
public class BlogData {
	private String postUrl;
	private String postTitle;
	private String postDescription;
	private int postWatch;
	private int postStar;
	private int postFork;
	private int postContributer;
	private String postReadme;
	private String postReadMeText;
	private List<String> categoryName;
	private Author author;
	
}
