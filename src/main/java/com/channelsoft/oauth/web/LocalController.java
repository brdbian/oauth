package com.channelsoft.oauth.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.oauth.po.UserProfile;
import com.channelsoft.oauth.service.UserProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value = "/local")
public class LocalController {
	private ObjectMapper objectMapper = null;
	@Autowired(required=true)
	private UserProfileService userProfileService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<UserProfile> getUserProfile(ModelMap model) {
		return userProfileService.getAllUserProfile();
	}
	
	@RequestMapping(value = "/user/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserProfile getUserProfile(@PathVariable("id") Long id) {
		
		System.out.println(((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
		System.out.println(userProfileService.getuserProfile(id));
		return userProfileService.getuserProfile(id);
	}
	
//	@RequestMapping(value = "/auth/denied", method = RequestMethod.GET)
//	public String getDeniedPage(ModelMap model) {
//		model.addAttribute("message", "user denied");
//		return "deniedpage";
//	}
//	
//	@RequestMapping(value = "/auth/login", method = RequestMethod.GET)  
//    public String getLoginPage(@RequestParam(value = "error", required = false) boolean error,  
//            ModelMap model) {  
//  
//        if (error == true) {  
//            // Assign an error message  
//            model.put("error",  
//                    "You have entered an invalid username or password!");  
//        } else {  
//            model.put("error", "");  
//        }  
//        
//        return "loginpage";  
//  
//    } 
//	
//	@RequestMapping(value = "/main/common", method = RequestMethod.GET)  
//    public String getCommonPage() {  
//        return "commonpage";  
//    }  
//	@RequestMapping(value = "/main/admin", method = RequestMethod.GET)  
//    public String getAdminPage() {  
//        return "adminpage";  
//    }  
//	@RequestMapping(value = "/auth/common", method = RequestMethod.GET)  
//    public ResponseEntity<String> getAuthCommon() {  
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Content-Type", "application/json");
//		return new ResponseEntity<String>("{name:mimimi}", headers, HttpStatus.OK);
//    }  
}
