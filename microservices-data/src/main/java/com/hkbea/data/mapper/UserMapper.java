package com.hkbea.data.mapper;

import java.util.List;

import com.hkbea.data.model.SysRole;
import com.hkbea.data.model.SysUser;

public interface UserMapper {

	SysUser selectById(Long id);
	
	List<SysUser> selectAll();
	
	List<SysRole> selectRolesByUserId(Long id);
	
	int insert(SysUser sysUser);
}
