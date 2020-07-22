package io.jxxchallenger.data.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.jxxchallenger.data.mapper.UserMapper;
import io.jxxchallenger.data.model.SysRole;
import io.jxxchallenger.data.model.SysUser;

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
	
	//@Test(priority = 7)
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
	
	@Test(priority = 8)
	public void testSelectByUser(){
		SqlSession session = getSqlSession();
		
		SysUser sysUser = new SysUser();
		sysUser.setUserName("admin");
		sysUser.setUserEmail("admin@qq.com");
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			List<SysUser> users = mapper.selectByUser(sysUser);
			Assert.assertTrue(users.size() > 0);
		} finally {
			session.close();
		}
	}
	
	@Test(priority = 11)
	public void testSelectByIdOrUserName(){
		SqlSession session = getSqlSession();
		
		SysUser sysUser = new SysUser();
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			SysUser sysUser2 = mapper.selectByIdOrUserName(sysUser);
			Assert.assertNull(sysUser2);
		} finally {
			session.close();
		}
	}
	
	@Test(priority = 12)
	public void testSelectByIdList(){
		SqlSession session = getSqlSession();
		
		List<Long> ids = new ArrayList<Long>();
		ids.add(10000L);
		ids.add(10001L);
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			List<SysUser> sysUsers = mapper.selectByIdList(ids);
			Assert.assertEquals(sysUsers.size(), 2);
		} finally {
			session.close();
		}
	}
	
	//@Test(priority = 13)
	public void testBatchInsert(){
		SqlSession session = getSqlSession();
		
		List<SysUser> sysUsers = new ArrayList<SysUser>();
		for(int i = 0; i < 2; i++){
			SysUser sysUser = new SysUser();
			sysUser.setUserName("test batch insert " + i);
			sysUser.setUserPassword("123456");
			sysUser.setUserEmail("batch@qq.com");
			sysUser.setUserInfo("batch123456");
			sysUser.setHeadImg(new byte[]{1, 2, 3});
			sysUser.setCreateTime(new Date());
			sysUsers.add(sysUser);
		}
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			int count = mapper.batchInsert(sysUsers);
			session.commit();
			Assert.assertEquals(count, 2);
		} finally {
			session.close();
		}
		
	}
	
	@Test(priority = 14)
	public void testSelectUserAndRoleById(){
		SqlSession session = getSqlSession();
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			SysUser sysUser = mapper.selectUserAndRoleById(10000L);
			Assert.assertNotNull(sysUser.getRole());
		} finally {
			session.close();
		}
	}
	
	@Test(priority = 15)
	public void testSelectUserAndRoleById2(){
		SqlSession session = getSqlSession();
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			SysUser sysUser = mapper.selectUserAndRoleById2(10000L);
			Assert.assertNotNull(sysUser.getRole());
		} finally {
			session.close();
		}
	}
	
	@Test(priority = 16)
	public void testselectAllUserAndRoles(){
		SqlSession session = getSqlSession();
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			List<SysUser> users = mapper.selectAllUserAndRoles();
			Assert.assertNotNull(users);
		} finally {
			session.close();
		}
	}
}
