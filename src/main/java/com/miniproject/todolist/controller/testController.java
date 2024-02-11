package com.miniproject.todolist.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class testController {

	@GetMapping("/login")
	public ModelAndView testJsp(HttpServletRequest request) {
		ModelAndView  test = new ModelAndView("commons/Login");
		return test;
	}
}
