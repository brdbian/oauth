package com.channelsoft.oauth;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.channelsoft.oauth.dao.PlanDao;
import com.channelsoft.oauth.dao.UserPlanDao;
import com.channelsoft.oauth.dao.UserProfileDao;
import com.channelsoft.oauth.po.Plan;
import com.channelsoft.oauth.po.UserPlan;
import com.channelsoft.oauth.po.UserProfile;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class PlanDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	protected DataSource dataSource;

	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
		this.dataSource = dataSource;
	}
	
	@Autowired(required=true)
	private PlanDao planDao;

	@Test
	public void findAll() throws Exception {
		List<Plan> userPlan = (List<Plan>)planDao.findAll();
		assertEquals(2, userPlan.size());
	}
	
}
