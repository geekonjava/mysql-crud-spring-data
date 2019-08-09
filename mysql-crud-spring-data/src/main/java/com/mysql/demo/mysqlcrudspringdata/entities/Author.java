package com.mysql.demo.mysqlcrudspringdata.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="author")
@Data
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long authorId;
	private String authorName;
	private String authorUrl;
	private String authorProfilePic;
	private String authorUsername;
	private String authorDescription;
	private String authorDetails;
	private String authorLocation;
	private String authorScore;
	private String authorRepo;
	private String authorGist;
	private String authorRank;
}
