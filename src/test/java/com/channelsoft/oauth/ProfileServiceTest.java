package com.channelsoft.oauth;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.channelsoft.oauth.dao.UserProfileDao;
import com.channelsoft.oauth.po.UserProfile;
import com.channelsoft.oauth.service.UserProfileService;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ProfileServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	protected DataSource dataSource;

	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
		this.dataSource = dataSource;
	}
	
	@Autowired(required=true)
	private UserProfileService userProfileDaoService;

	@Test
	public void update() throws Exception {
		UserProfile userProfiles = userProfileDaoService.getUserProfile("mkyong");
		System.out.println(userProfiles.getAddress());
		userProfiles.setAddress("newAdd");
		System.out.println(userProfiles.getAddress());
		userProfileDaoService.saveProfile(userProfiles);
	}
}
