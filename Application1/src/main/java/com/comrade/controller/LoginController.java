package com.comrade.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.comrade.entity.User;
import com.comrade.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User(username, password);
		boolean flag = userService.validateUser(user);

		request.setAttribute("userName", username);

		ModelAndView mv = new ModelAndView();

		if (flag) {
			mv.setViewName("redirect:/display");
		} else {
			throw new RuntimeException("Incorrect userName or password");
		}
		return mv;
	}

}
