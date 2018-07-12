package com.hkbea.data.mapper;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hkbea.data.model.SysUser;

public class SpringMyBatisTest {

	private UserMapper userMapper;
	
	@BeforeClass
	public void setup(){
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:com/hkbea/data/spring/ApplicationContext-mybatis.xml");
		this.userMapper = applicationContext.getBean(UserMapper.class);
	}
	
	@Test(priority = 1)
	public void testSpringMybatis(){
		List<SysUser> sysUsers = this.userMapper.selectAll();
		Assert.assertNotNull(sysUsers);
		
	}
	
	
	
}
