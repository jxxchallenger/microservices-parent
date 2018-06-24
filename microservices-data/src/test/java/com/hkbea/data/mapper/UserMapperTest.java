package com.hkbea.data.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hkbea.data.model.SysRole;
import com.hkbea.data.model.SysUser;

public class UserMapperTest extends BaseMapperTest {

	@Test(priority = 1)
	public void testSelectById(){
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = userMapper.selectById(10000L);
			Assert.assertNotNull(sysUser);
			Assert.assertEquals(sysUser.getUserName(), "admin");
		} finally {
			sqlSession.close();
		}
	}
	
	@Test(priority = 2)
	public void testSelectAll(){
		SqlSession session = getSqlSession();
		
		try {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			List<SysUser> sysUsers = userMapper.selectAll();
			Assert.assertNotNull(sysUsers);
			Assert.assertTrue(sysUsers.size() > 0);
		} finally {
			session.close();
			
		}
	}
	
	@Test(priority = 3)
	public void testSelectRolesByUserId(){
		SqlSession session = getSqlSession();
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			List<SysRole> roles = mapper.selectRolesByUserId(10001L);
			Assert.assertEquals(roles.size(), 1);
		} finally {
			session.close();
		}
	}
	
	//@Test(priority = 4)
	public void testInsert(){
		SqlSession session = getSqlSession();
		
		try {
			SysUser user = new SysUser();
			user.setUserName("test3");
			user.setUserPassword("123456");
			user.setUserEmail("test3@qq.com");
			user.setUserInfo("test3 info");
			user.setHeadImg(new byte[] { 1, 2, 3 });
			user.setCreateTime(new Date());
			UserMapper mapper = session.getMapper(UserMapper.class);
			int id = mapper.insert(user);
			
			
			session.commit();
			
			Assert.assertNotNull(user.getId());
		} finally {
			session.close();
		}
	}
	
	//@Test(priority = 5)
	public void testInsert3(){
		SqlSession session = getSqlSession();
		
		try {
			SysUser user = new SysUser();
			user.setUserName("test4");
			user.setUserPassword("123456");
			user.setUserEmail("test4@qq.com");
			user.setUserInfo("test4 info");
			user.setHeadImg(new byte[] { 1, 2, 3 });
			//user.setCreateTime(new Date());
			UserMapper mapper = session.getMapper(UserMapper.class);
			int id = mapper.insert3(user);
			
			
			session.commit();
			Assert.assertEquals(id, 1);
			Assert.assertNotNull(user.getId());
		} finally {
			session.close();
		}
	}
	
	//@Test(priority = 6)
	public void testUpdateById(){
		SqlSession session = getSqlSession();
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			SysUser user = new SysUser();
			user.setId(10002L);
			user.setUserName("username");
			user.setUserPassword("123456789");
			user.setUserEmail("763615181@qq.com");
			user.setUserInfo("hello");
			user.setHeadImg(new byte[] { 1, 2, 3 });
			user.setCreateTime(new Date());
			int count = mapper.updateById(user);
			session.commit();
			Assert.assertEquals(count, 1);
		} finally {
			session.close();
		}
		
	}
	
	@Test(priority = 7)
	public void testDeleteById(){
		SqlSession session = getSqlSession();
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			int result = mapper.deleteById(10002L);
			Assert.assertEquals(result, 1);
			session.commit();
		} finally {
			session.close();
		}
		
	}
}
