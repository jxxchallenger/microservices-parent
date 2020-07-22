package io.jxxchallenger.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 练习{@code @ControllerAdvice}
 * @author Chen
 *
 */
@Controller
@RequestMapping(value = {"/controller"})
public class SampleController {

	@GetMapping(value = "/advice")
	public ModelAndView showCase(ModelAndView mv) {
		mv.setViewName("testAdvice");
		mv.addObject("testAdvice", "val 1");
		return mv;
	}
	
	@GetMapping(value = {"/exception"})
	public ModelAndView showCase2(ModelAndView mv) throws Exception{
		mv.setViewName("/testAdvice");
		mv.addObject("testAdvice", 1/0);
		return mv;
		
	}
}
