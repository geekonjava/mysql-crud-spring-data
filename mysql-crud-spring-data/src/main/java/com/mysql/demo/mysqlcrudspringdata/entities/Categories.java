package com.mysql.demo.mysqlcrudspringdata.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="categories")
@Data
public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categorieId;
	private String categorieName;
}
