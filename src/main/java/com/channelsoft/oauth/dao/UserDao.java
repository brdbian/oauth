package com.channelsoft.oauth.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.channelsoft.oauth.po.Plan;
import com.channelsoft.oauth.po.User;


public interface UserDao extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {
	User findByUsername(String username);
}
