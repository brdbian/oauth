package com.channelsoft.oauth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.channelsoft.oauth.dao.PlanDao;
import com.channelsoft.oauth.dao.UserPlanDao;
import com.channelsoft.oauth.dao.UserProfileDao;
import com.channelsoft.oauth.po.Plan;
import com.channelsoft.oauth.po.UserPlan;
import com.channelsoft.oauth.po.UserProfile;


//Spring Bean的标识.
@Component
// 默认将类中的所有public函数纳入事务管理.
@Transactional
public class PlanService {
	@Autowired
	private PlanDao planDao;

	public Plan getPlan(Long id) {
		return planDao.findOne(id);
	}
	
	public List<Plan> getAllPlan() {
		return (List<Plan>) planDao.findAll();
	}
	
}
