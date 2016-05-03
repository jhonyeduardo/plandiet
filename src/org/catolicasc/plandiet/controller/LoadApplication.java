package org.catolicasc.plandiet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoadApplication {

	@RequestMapping("/")
	public String redirectToList() {
		return "redirect:food/list";
	}
	
}
