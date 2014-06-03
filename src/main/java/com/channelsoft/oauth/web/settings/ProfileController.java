package com.channelsoft.oauth.web.settings;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.channelsoft.oauth.po.Plan;
import com.channelsoft.oauth.po.UserPlan;
import com.channelsoft.oauth.po.UserProfile;
import com.channelsoft.oauth.service.PlanService;
import com.channelsoft.oauth.service.UserPlanService;
import com.channelsoft.oauth.service.UserProfileService;
import com.channelsoft.oauth.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value = "/settings/profile")
public class ProfileController {
	@Autowired(required=true)
	private UserProfileService userProfileService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String getUserProfile(Model model) {
		String username = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		UserProfile userProfile = userProfileService.getUserProfile(username);
		model.addAttribute("userProfile", userProfile);
		System.out.println(11);
		return "settings/profile";
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveUserProfile(@Valid @ModelAttribute("userProfile") UserProfile userProfile,RedirectAttributes redirectAttributes,Principal principal) {
		userProfileService.saveProfile(userProfile);
		redirectAttributes.addFlashAttribute("message", "修改用户资料成功！");
		return "redirect:/settings/profile";
	}
	
	/**
	 * 所有RequestMapping方法调用前的Model准备方法, 实现Struts2 Preparable二次部分绑定的效果,先根据form的id从数据库查出Task对象,再把Form提交的内容绑定到该对象上。
	 * 因为仅update()方法的form中有id属性，因此仅在update时实际执行.
	 */
	@ModelAttribute
	public void getUserProfile(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
		if (id != -1) {
			model.addAttribute("userProfile", userProfileService.getuserProfile(id));
		}
	}
}
