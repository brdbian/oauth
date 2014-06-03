package com.channelsoft.oauth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.channelsoft.oauth.dao.PlanDao;
import com.channelsoft.oauth.dao.UserDao;
import com.channelsoft.oauth.dao.UserPlanDao;
import com.channelsoft.oauth.dao.UserProfileDao;
import com.channelsoft.oauth.po.Plan;
import com.channelsoft.oauth.po.User;
import com.channelsoft.oauth.po.UserPlan;
import com.channelsoft.oauth.po.UserProfile;


//Spring Bean的标识.
@Component
// 默认将类中的所有public函数纳入事务管理.
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;

	public User getUser(Long id) {
		return userDao.findOne(id);
	}
	
	public List<User> getAllUser() {
		return (List<User>) userDao.findAll();
	}
	
	public User getUser(String username) {
		return userDao.findByUsername(username);
	}
	
}
