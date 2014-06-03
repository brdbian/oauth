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

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ProfileDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	protected DataSource dataSource;

	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
		this.dataSource = dataSource;
	}
	
	@Autowired(required=true)
	private UserProfileDao userProfileDao;

	@Test
	public void findTasksByUserId() throws Exception {
		Page<UserProfile> userProfiles = userProfileDao.findById(2L, new PageRequest(0, 100, Direction.ASC, "id"));
		assertEquals(1, userProfiles.getContent().size());
		assertEquals(new Long(2), userProfiles.getContent().get(0).getId());

		userProfiles = userProfileDao.findById(99999L, new PageRequest(0, 100, Direction.ASC, "id"));
		assertEquals(0, userProfiles.getContent().size());
	}
	
	@Test
	public void findTasksByUserUsername() throws Exception {
		UserProfile userProfiles = userProfileDao.findByUserUsername("mkyong");
		assertEquals("mkyong@gmail.com", userProfiles.getPrivateEmail());
		UserProfile userProfiles1 = userProfileDao.findByUserUsername("hehg");
		assertEquals("hehg@gmail.com", userProfiles1.getPrivateEmail());
	}
}
