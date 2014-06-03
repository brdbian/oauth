package com.channelsoft.oauth.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.channelsoft.oauth.po.UserProfile;


public interface UserProfileDao extends PagingAndSortingRepository<UserProfile, Long>, JpaSpecificationExecutor<UserProfile> {

	Page<UserProfile> findById(Long id, Pageable pageRequest);
	
	UserProfile findByUserUsername(String userUsername);

	@Modifying
	@Query("delete from UserProfile userProfile where userProfile.id=?1")
	void deleteById(Long id);
}
