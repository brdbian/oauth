package com.channelsoft.oauth.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.channelsoft.oauth.po.Plan;


public interface PlanDao extends PagingAndSortingRepository<Plan, Long>, JpaSpecificationExecutor<Plan> {
	
}
