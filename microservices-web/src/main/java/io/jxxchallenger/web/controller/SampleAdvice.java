package io.jxxchallenger.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SampleAdvice {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleAdvice.class);
	
	@ModelAttribute(value = "attr1")
	public String modelAdive() {
		return "add by @ModlAttribute";
	}
	
	@ExceptionHandler(value = {Exception.class})
	public ModelAndView hanlderException(HttpServletResponse httpServletResponse, ModelAndView mv) {
		//BaseResponse response = new BaseResponse();
		LOGGER.info("hello world from hanlderException method of SampleAdvice class");
		//httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return mv;
	}
}
