package com.channelsoft.oauth.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.oauth.po.UserProfile;
import com.channelsoft.oauth.service.UserProfileService;

@Controller
@RequestMapping(value = "/api/profile")
public class ApiProfileController {
	@Autowired(required=true)
	private UserProfileService userProfileService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserProfile getUserProfile() {
		String username = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		
		UserProfile userProfile= userProfileService.getUserProfile(username);
		return userProfile;
		
	}
	
//	@RequestMapping(method = RequestMethod.POST)
//	@ResponseBody
//	public void saveUserProfile(@RequestParam(value = "name", required = false)String name,
//			@RequestParam(value = "address", required = false)String address){
//		String username = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
//		UserProfile userProfile= userProfileService.getUserProfile(username);
//		userProfile.setAddress(address);
//		userProfile.setName(name);
//	}
}
