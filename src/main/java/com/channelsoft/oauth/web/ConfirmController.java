//package com.channelsoft.oauth.web;
//
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.oauth2.provider.AuthorizationRequest;
//import org.springframework.security.oauth2.provider.ClientDetails;
//import org.springframework.security.oauth2.provider.JdbcClientDetailsService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//@SessionAttributes("authorizationRequest")
//public class ConfirmController {
//	private JdbcClientDetailsService clientDetails;
//
//	@RequestMapping("/oauth/confirm_access")
//	public ModelAndView getAccessConfirmation(Map<String, Object> model) throws Exception {
//		AuthorizationRequest clientAuth = (AuthorizationRequest) model.remove("authorizationRequest");
//		ClientDetails client = clientDetails.loadClientByClientId(clientAuth.getClientId());
//		model.put("auth_request", clientAuth);
//		model.put("client", client);
//		System.out.println("dd");
//		return new ModelAndView("confirm_access", model);
//	}
//	
//	@RequestMapping("/oauth/error")
//	public String handleError(Map<String,Object> model) throws Exception {
//		// We can add more stuff to the model here for JSP rendering.  If the client was a machine then
//		// the JSON will already have been rendered.
//		model.put("message", "OAuth2 protocol error");
//		return "oauth_error";
//	}
//	
//	@Autowired
//	public void setClientDetails(JdbcClientDetailsService clientDetails) {
//		this.clientDetails = clientDetails;
//	}
//}
