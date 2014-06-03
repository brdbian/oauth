package com.channelsoft.oauth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.channelsoft.oauth.dao.UserProfileDao;
import com.channelsoft.oauth.po.UserProfile;


//Spring Bean的标识.
@Component
// 默认将类中的所有public函数纳入事务管理.
@Transactional
public class UserProfileService {
	@Autowired
	private UserProfileDao userProfileDao;

	public UserProfile getuserProfile(Long id) {
		return userProfileDao.findOne(id);
	}
	public void saveProfile(UserProfile entity) {
		userProfileDao.save(entity);
	}

	public void deleteTask(Long id) {
		userProfileDao.delete(id);
	}
	public List<UserProfile> getAllUserProfile() {
		return (List<UserProfile>) userProfileDao.findAll();
	}
	
	public UserProfile getUserProfile(String username) {
		return userProfileDao.findByUserUsername(username);
	}
	/**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "id");
		} else if ("title".equals(sortType)) {
			sort = new Sort(Direction.ASC, "title");
		}

		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}


	
}
