package com.channelsoft.oauth.po;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//JPA标识
@Entity
@Table(name = "user_profile")
public class UserProfile {

	private Long id;
	private String name;
	private String publicEmail;
	private String url;
	private String company;
	private String address;
	private String privateEmail;
	private User user;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
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

	public String getPublicEmail() {
		return publicEmail;
	}

	public void setPublicEmail(String publicEmail) {
		this.publicEmail = publicEmail;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPrivateEmail() {
		return privateEmail;
	}

	public void setPrivateEmail(String privateEmail) {
		this.privateEmail = privateEmail;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	// JSR303 BeanValidator的校验规则

//	 JPA 基于USER_ID列的一对一关系定义
	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name = "user_user_id")
	// @JsonIgnore
	 public User getUser() {
		 return user;
	 }
	
	 public void setUser(User user) {
		 this.user = user;
	 }
}
