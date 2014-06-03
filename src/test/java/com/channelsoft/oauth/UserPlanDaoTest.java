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

import com.channelsoft.oauth.dao.UserPlanDao;
import com.channelsoft.oauth.dao.UserProfileDao;
import com.channelsoft.oauth.po.UserPlan;
import com.channelsoft.oauth.po.UserProfile;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class UserPlanDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	protected DataSource dataSource;

	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
		this.dataSource = dataSource;
	}
	
	@Autowired(required=true)
	private UserPlanDao userPlanDao;

	@Test
	public void findByUserUserId() throws Exception {
		UserPlan userPlan = userPlanDao.findByUserUserId(101L);
		assertEquals("200套餐", userPlan.getPlan().getName());
	}
	
	@Test
	public void findByUserUsername() throws Exception {
		UserPlan userPlan = userPlanDao.findByUserUsername("hehg");
		assertEquals("200套餐", userPlan.getPlan().getName());
	}
	
}
