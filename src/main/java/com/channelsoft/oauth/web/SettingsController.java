//package com.channelsoft.oauth.web;
//
//import java.security.Principal;
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.channelsoft.oauth.po.Plan;
//import com.channelsoft.oauth.po.UserPlan;
//import com.channelsoft.oauth.po.UserProfile;
//import com.channelsoft.oauth.service.PlanService;
//import com.channelsoft.oauth.service.UserPlanService;
//import com.channelsoft.oauth.service.UserProfileService;
//import com.channelsoft.oauth.service.UserService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Controller
//@RequestMapping(value = "/settings")
//public class SettingsController {
//	@Autowired(required=true)
//	private UserProfileService userProfileService;
//	@Autowired(required=true)
//	private UserPlanService userPlanService;
//	@Autowired(required=true)
//	private PlanService planService;
//	@Autowired(required=true)
//	private UserService userService;
//	
//	@RequestMapping(value = "/profile",method = RequestMethod.GET)
//	public String getUserProfile(Model model) {
//		String username = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
//		UserProfile userProfile = userProfileService.getUserProfile(username);
//		model.addAttribute("userProfile", userProfile);
//		return "settings/profile";
//	}
//	
//	@RequestMapping(value = "/profile/save",method = RequestMethod.POST)
//	public String saveUserProfile(@Valid @ModelAttribute("userProfile") UserProfile userProfile,RedirectAttributes redirectAttributes,Principal principal) {
////		userProfile.setUser(userService.getUser(principal.getName()));
//		userProfileService.saveProfile(userProfile);
//		redirectAttributes.addFlashAttribute("message", "修改用户资料成功！");
//		return "redirect:/settings/profile";
//	}
//	
//	@RequestMapping(value = "/admin",method = RequestMethod.GET)
//	public String getAdmin(ModelMap model) {
//		String username = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
//		UserProfile userProfile = userProfileService.getUserProfile(username);
//		model.addAttribute("userProfile", userProfile);
//		return "settings/admin";
//	}
//	
//	@RequestMapping(value = "/billing",method = RequestMethod.GET)
//	public String getBilling(ModelMap model) {
//		String username = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
//		List<Plan> plans = planService.getAllPlan();
//		UserPlan userPlan = userPlanService.getPlan(username);
//		model.addAttribute("plans", plans);
//		model.addAttribute("userPlan", userPlan);
//		return "settings/billing";
//	}
//	
//	/**
//	 * 所有RequestMapping方法调用前的Model准备方法, 实现Struts2 Preparable二次部分绑定的效果,先根据form的id从数据库查出Task对象,再把Form提交的内容绑定到该对象上。
//	 * 因为仅update()方法的form中有id属性，因此仅在update时实际执行.
//	 */
//	@ModelAttribute
//	public void getUserProfile(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
//		if (id != -1) {
//			model.addAttribute("userProfile", userProfileService.getuserProfile(id));
//		}
//	}
//	
////	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
////	@ResponseBody
////	public List<UserProfile> getUserProfile(ModelMap model) {
////		return userProfileService.getAllUserProfile();
////	}
////	
////	@RequestMapping(value = "/user/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
////	@ResponseBody
////	public UserProfile getUserProfile(@PathVariable("id") Long id) {
////		
////		System.out.println(((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
////		System.out.println(userProfileService.getuserProfile(id));
////		return userProfileService.getuserProfile(id);
////	}
//	
////	@RequestMapping(value = "/auth/denied", method = RequestMethod.GET)
////	public String getDeniedPage(ModelMap model) {
////		model.addAttribute("message", "user denied");
////		return "deniedpage";
////	}
////	
////	@RequestMapping(value = "/auth/login", method = RequestMethod.GET)  
////    public String getLoginPage(@RequestParam(value = "error", required = false) boolean error,  
////            ModelMap model) {  
////  
////        if (error == true) {  
////            // Assign an error message  
////            model.put("error",  
////                    "You have entered an invalid username or password!");  
////        } else {  
////            model.put("error", "");  
////        }  
////        
////        return "loginpage";  
////  
////    } 
////	
////	@RequestMapping(value = "/main/common", method = RequestMethod.GET)  
////    public String getCommonPage() {  
////        return "commonpage";  
////    }  
////	@RequestMapping(value = "/main/admin", method = RequestMethod.GET)  
////    public String getAdminPage() {  
////        return "adminpage";  
////    }  
////	@RequestMapping(value = "/auth/common", method = RequestMethod.GET)  
////    public ResponseEntity<String> getAuthCommon() {  
////		HttpHeaders headers = new HttpHeaders();
////		headers.set("Content-Type", "application/json");
////		return new ResponseEntity<String>("{name:mimimi}", headers, HttpStatus.OK);
////    }  
//}
