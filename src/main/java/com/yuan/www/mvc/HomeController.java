package com.yuan.www.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/", "/home" })
public class HomeController {

	@RequestMapping({ "/", "/home" })
	public String toHome() {
		return "login";

	}

}
