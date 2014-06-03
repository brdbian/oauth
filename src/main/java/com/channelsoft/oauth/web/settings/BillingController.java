package com.channelsoft.oauth.web.settings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.channelsoft.oauth.po.Plan;
import com.channelsoft.oauth.po.UserPlan;
import com.channelsoft.oauth.service.PlanService;
import com.channelsoft.oauth.service.UserPlanService;

@Controller
@RequestMapping(value = "/settings/billing")
public class BillingController {
	@Autowired(required=true)
	private PlanService planService;
	@Autowired(required=true)
	private UserPlanService userPlanService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String getBilling(ModelMap model) {
		String username = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		List<Plan> plans = planService.getAllPlan();
		UserPlan userPlan = userPlanService.getPlan(username);
		model.addAttribute("plans", plans);
		model.addAttribute("userPlan", userPlan);
		return "settings/billing";
	}
}
