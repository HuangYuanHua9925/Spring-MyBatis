package com.yuan.www.mvc;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuan.www.service.TeacherService;

@Controller
@RequestMapping({ "/", "/home" })
public class HomeController {
	@Autowired
	static TeacherService teacherService;

	@RequestMapping({ "/", "/home" })
	public String toHome() {
		return "login";

	}

}
