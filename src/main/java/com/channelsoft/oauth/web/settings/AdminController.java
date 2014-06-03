package com.channelsoft.oauth.web.settings;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/settings/admin")
public class AdminController {
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String getAdmin(ModelMap model) {
		return "settings/admin";
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveAdmin(@RequestParam(value="pass") String pass,ModelMap model) {
		return "settings/admin";
	}
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
}
