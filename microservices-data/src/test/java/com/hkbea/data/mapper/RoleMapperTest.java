package com.hkbea.data.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hkbea.data.model.SysRole;

public class RoleMapperTest extends BaseMapperTest {

	@Test(priority = 1)
	public void testSelectRoleByUserIdAndRoleEnabled(){
		SqlSession session = getSqlSession();
		
		try {
			RoleMapper mapper = session.getMapper(RoleMapper.class);
			List<SysRole> sysRoles = mapper.selectRoleByUserIdAndRoleEnabled(10000L, 1);
			Assert.assertTrue(sysRoles.size() > 0);
		} finally {
			session.close();
		}
	}
	
	@Test(priority = 2)
	public void testSelectById(){
		SqlSession session = getSqlSession();
		
		try {
			RoleMapper mapper = session.getMapper(RoleMapper.class);
			SysRole role = mapper.selectById(10000L);
			Assert.assertNotNull(role);
		} finally {
			session.close();
		}
		
	}
	
	@Test(priority = 3)
	public void testSelectById2(){
		SqlSession session = getSqlSession();
		
		try {
			RoleMapper mapper = session.getMapper(RoleMapper.class);
			SysRole role = mapper.selectById2(10000L);
			Assert.assertNotNull(role);
		} finally {
			session.close();
		}
		
	}
	
	@Test(priority = 4)
	public void testInsert(){
		SqlSession session = getSqlSession();
		
		SysRole role = new SysRole();
		role.setId(System.currentTimeMillis());
		role.setRoleName("test role");
		role.setEnabled(1);
		role.setCreateBy(10000L);
		role.setCreateTime(new Date());
		
		try {
			RoleMapper roleMapper = session.getMapper(RoleMapper.class);
			int result = roleMapper.insert(role);
			Assert.assertEquals(result, 1);
			session.commit();
		} finally {
			session.close();
		}
		
	}
	
	@Test(priority = 5)
	public void testInsert2(){
		SqlSession session = getSqlSession();
		
		SysRole role = new SysRole();
		//role.setId(System.currentTimeMillis());
		role.setRoleName("test insert role 2");
		role.setEnabled(1);
		role.setCreateBy(10000L);
		role.setCreateTime(new Date());
		
		try {
			RoleMapper mapper = session.getMapper(RoleMapper.class);
			int result = mapper.insert2(role);
			Assert.assertEquals(result, 1);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	@Test(priority = 6)
	public void testInsert3(){
		SqlSession session = getSqlSession();
		
		SysRole role = new SysRole();
		//role.setId(System.currentTimeMillis());
		role.setRoleName("test insert role 3");
		role.setEnabled(1);
		role.setCreateBy(10000L);
		role.setCreateTime(new Date());
		
		try {
			RoleMapper roleMapper = session.getMapper(RoleMapper.class);
			int result = roleMapper.insert3(role);
			Assert.assertEquals(result, 1);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	@Test(priority = 7)
	public void testUpateById(){
		SqlSession session = getSqlSession();
		
		SysRole role = new SysRole();
		role.setId(10001L);
		role.setRoleName("普通用户");
		role.setEnabled(1);
		role.setCreateBy(10000L);
		role.setCreateTime(new Date());
		
		try {
			RoleMapper roleMapper = session.getMapper(RoleMapper.class);
			int result = roleMapper.updateById(role);
			session.commit();
			Assert.assertEquals(result, 1);
		} finally {
			session.close();
		}
	}
	
	@DataProvider(name = "deleteId")
	public Object[][] getDeleteId(){
		Object[][] deletes = new Object[1][2];
		SqlSession session = getSqlSession();
		
		SysRole role = new SysRole();
		role.setRoleName("普通用户");
		role.setEnabled(1);
		role.setCreateBy(10000L);
		role.setCreateTime(new Date());
		
		try {
			RoleMapper mapper = session.getMapper(RoleMapper.class);
			int result = mapper.insert2(role);
			Assert.assertEquals(result, 1);
			session.commit();
		} finally {
			session.close();
		}
		deletes[0][0] = "delete id";
		deletes[0][1] = role.getId();
		
		return deletes;
	}
	
	@Test(priority = 8, dataProvider = "deleteId")
	public void testDeleteById(String name, Long deleteId){
		SqlSession session = getSqlSession();
		
		try {
			RoleMapper roleMapper = session.getMapper(RoleMapper.class);
			int result = roleMapper.deleteById(deleteId);
			session.commit();
			Assert.assertEquals(result, 1);
		} finally {
			session.close();
		}
	}
}
