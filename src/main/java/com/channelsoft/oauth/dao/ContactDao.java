package com.channelsoft.oauth.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.channelsoft.oauth.po.Contact;
import com.channelsoft.oauth.po.Plan;


public interface ContactDao extends PagingAndSortingRepository<Contact, Long>, JpaSpecificationExecutor<Contact> {
	List<Contact> findByUserUsername(String userUsername);
}
