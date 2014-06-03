package com.channelsoft.oauth.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
public class OauthController {
	private ObjectMapper objectMapper = null;
	@Autowired(required=true)
	private UserProfileService userProfileService;
	
	@RequestMapping(value = "/testmvc", method = RequestMethod.GET)
	public String getTestPage(ModelMap model) {
		model.addAttribute("message", "测试mvc");
		return "testmvc";
	}
	@RequestMapping(value = "/testre", method = RequestMethod.GET)
	public String getTestPage1(ModelMap model) {
		model.addAttribute("message", "测试remember");
		return "testmvc";
	}
//	@RequestMapping(value = "/auth/userProfile", method = RequestMethod.GET)
//	public ResponseEntity<String> getUserProfile1(ModelMap model) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Content-Type", "application/json");
//		return new ResponseEntity<String>("{name:123}", headers, HttpStatus.OK);
//	}
	
//	@RequestMapping(value = "/auth/userProfile", method = RequestMethod.GET)
//	public ResponseEntity<String> getUserProfile(ModelMap model) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Content-Type", "application/json");
//		Page<UserProfile> userProfiles = userProfileDao.findById(2L, new PageRequest(0, 100, Direction.ASC, "id"));
//		return new ResponseEntity<String>(userProfiles, headers, HttpStatus.OK);
//	}
	
	
	
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
