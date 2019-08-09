package com.mysql.demo.mysqlcrudspringdata.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;



import lombok.Data;

@Entity
@Table(name="article")
@Data
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String postUrl;
	private String postTitle;
	private String postDescription;
	private int postWatch;
	private int postStar;
	private int postFork;
	private int postContributer;
	@Lob
	private String postReadme;
	@Lob
	private String postReadMeText;
	private String postAddedTime;
	private String postUpdatedTime;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Author author;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Categories> categories;
	
	@PrePersist
	protected void prePersist() {
		Date myDate = new Date();
		if(this.postAddedTime == null) this.postAddedTime = new SimpleDateFormat("yyyy-MM-dd").format(myDate);
	}
	
	@PreUpdate
	protected void preMerge() {
		Date myDate = new Date();
		if(this.postUpdatedTime == null) this.postUpdatedTime = new SimpleDateFormat("yyyy-MM-dd").format(myDate);
	}
	

}
