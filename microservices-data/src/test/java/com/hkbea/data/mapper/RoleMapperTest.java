package com.hkbea.data.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
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
			session.commit();
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
			session.commit();
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
			session.commit();
		}
		
	}
	
}
