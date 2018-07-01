package com.hkbea.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.hkbea.data.model.SysRole;

public interface RoleMapper {

	List<SysRole> selectRoleByUserIdAndRoleEnabled(@Param(value = "userId") Long userId, @Param(value = "enabled") Integer enabled);
	
	@Select(value = { "SELECT id, role_name as roleName, enabled, create_by as createBy, create_time as createTime FROM sys_role WHERE id = #{id}" })
	SysRole selectById(Long id);
	
	@Results(value = {
			@Result(property = "id", column = "id", id = true),
			@Result(property = "roleName", column = "role_name"),
			@Result(property = "enabled", column = "enabled"),
			@Result(property = "createBy", column = "create_by"),
			@Result(property = "createTime", column = "create_time")
	})
	@Select(value = {"SELECT id, role_name, enabled, create_by, create_time FROM sys_role WHERE id = #{id}"})
	SysRole selectById2(Long id);
}
