package com.channelsoft.oauth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.channelsoft.oauth.dao.ContactDao;
import com.channelsoft.oauth.po.Contact;
import com.channelsoft.oauth.po.Plan;


//Spring Bean的标识.
@Component
// 默认将类中的所有public函数纳入事务管理.
@Transactional
public class ContactService {
	@Autowired
	private ContactDao contactDao;

	public Contact getPlan(Long id) {
		return contactDao.findOne(id);
	}
	
	public List<Contact> getAllContact() {
		return (List<Contact>) contactDao.findAll();
	}
	public List<Contact> getContactByUsername(String userUsername) {
		return (List<Contact>) contactDao.findByUserUsername(userUsername);
	}
}
