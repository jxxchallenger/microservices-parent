package com.hkbea.data.mapper;

import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hkbea.data.model.SysPrivilege;

public class PrivilegeMapperTest extends BaseMapperTest {

	@Test(priority = 1)
	public void testSelectById(){
		SqlSession session = getSqlSession();
		
		try {
			PrivilegeMapper mapper = session.getMapper(PrivilegeMapper.class);
			SysPrivilege privilege = mapper.selectById(10000L);
			Assert.assertNotNull(privilege);
		} finally {
			session.close();
		}
		
	}
}
