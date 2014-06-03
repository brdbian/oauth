package com.channelsoft.oauth.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.channelsoft.oauth.po.Plan;
import com.channelsoft.oauth.po.UserPlan;


public interface UserPlanDao extends PagingAndSortingRepository<UserPlan, Long>, JpaSpecificationExecutor<UserPlan> {
	UserPlan findByUserUserId(Long userUserId);
	UserPlan findByUserUsername(String userUsername);
}
