package com.yuan.www.mvc;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/main")
public class MainController {
	
	@RequestMapping(value="role",method=RequestMethod.GET)
	@RequiresRoles("role1")
	public String testRole(){
		Subject subject = SecurityUtils.getSubject();
		
		boolean hasRole = subject.hasRole("role1");
		
		System.out.println(subject.getPrincipal());
		
		System.out.println(hasRole);

		System.out.println("test roles;");
		return "role";
	}
	@RequestMapping(value="test",method=RequestMethod.GET)
	@RequiresPermissions("create")
	public String testModelAndView(){
		Map<String,String > model = new HashMap<String, String>();
		
		model.put("ex", "123");
		return "1";
		//return new ModelAndView("main",model);
	}
}
