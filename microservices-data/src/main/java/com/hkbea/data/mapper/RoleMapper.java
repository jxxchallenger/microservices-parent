package com.hkbea.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

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
	
	@Insert(value = { "INSERT INTO sys_role (id, role_name, enabled, create_by, create_time) VALUES(#{id}, #{roleName}, #{enabled}, #{createBy}, #{createTime, jdbcType=TIMESTAMP})" })
	int insert(SysRole sysRole);
	
	@Insert(value = { "INSERT INTO sys_role (role_name, enabled, create_by, create_time) VALUES(#{roleName}, #{enabled}, #{createBy}, #{createTime, jdbcType=TIMESTAMP})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert2(SysRole sysRole);
	
	@Insert(value = { "INSERT INTO sys_role (role_name, enabled, create_by, create_time) VALUES(#{roleName}, #{enabled}, #{createBy}, #{createTime, jdbcType=TIMESTAMP})" })
	@SelectKey(before = false, keyProperty = "id", resultType = Long.class, statement = { "SELECT LAST_INSERT_ID()" })
	int insert3(SysRole sysRole);
	
	@Update(value = { "UPDATE sys_role set role_name = #{roleName}, enabled = #{enabled}, create_by = #{createBy}, create_time = #{createTime} WHERE id = #{id, jdbcType=TIMESTAMP}" })
	int updateById(SysRole sysRole);
	
	@Delete(value = { "DELETE FROM sys_role WHERE id = #{id}" })
	int deleteById(Long id);
}
