package com.weathersearch.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String pass;
	
	private int datelevel;

	private Date createDate;
	
	private Long creator;
	
	public User() {
		this.datelevel = 0;
		this.createDate = new Date();
	}

	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
		this.datelevel = 0;
		this.createDate = new Date();
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getDatelevel() {
		return datelevel;
	}

	public void setDatelevel(int datelevel) {
		this.datelevel = datelevel;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}
	

}
