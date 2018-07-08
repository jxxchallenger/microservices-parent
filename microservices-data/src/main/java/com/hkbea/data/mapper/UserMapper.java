package com.hkbea.data.mapper;

import java.util.List;

import com.hkbea.data.model.SysRole;
import com.hkbea.data.model.SysUser;

public interface UserMapper {

	SysUser selectById(Long id);
	
	List<SysUser> selectAll();
	
	List<SysRole> selectRolesByUserId(Long id);
	
	int insert(SysUser sysUser);
	
	int insert3(SysUser sysUser);
	
	int updateById(SysUser sysUser);
	
	int deleteById(Long id);
	
	List<SysUser> selectByUser(SysUser sysUser);
	
	int updateByIdSelective(SysUser sysUser);
	
	SysUser selectByIdOrUserName(SysUser sysUser);
	
	List<SysUser> selectByIdList(List<Long> ids);
	
	int batchInsert(List<SysUser> users);
}
