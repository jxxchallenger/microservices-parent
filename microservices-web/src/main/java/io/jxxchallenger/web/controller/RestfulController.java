package io.jxxchallenger.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulController {

	@RequestMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, method = {RequestMethod.POST}, value = {"/rest/jsonForm"}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public JsonResult getJsonResult(String param1, String param2){
		
		JsonResult result = new JsonResult();
		
		List<String> data = new ArrayList<String>();
		data.add("fuck world!");
		result.setData(data);
		result.setStatus(1);
		result.setMessage("abc");
		
		return result;
		
	}
	
	
	@RequestMapping(consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, method = {RequestMethod.POST}, value = {"/rest/jsonBody"}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public JsonResult getJsonResult(@RequestBody JsonRequest requestBody){
		
		JsonResult result = new JsonResult();
		
		List<String> data = new ArrayList<String>();
		data.add("fuck world!");
		result.setData(data);
		result.setStatus(1);
		result.setMessage("abc");
		
		return result;
		
	}
	
}
