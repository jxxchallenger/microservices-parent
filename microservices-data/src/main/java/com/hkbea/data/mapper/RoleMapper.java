package com.hkbea.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hkbea.data.model.SysRole;

public interface RoleMapper {

	List<SysRole> selectRoleByUserIdAndRoleEnabled(@Param(value = "userId") Long userId, @Param(value = "enabled") Integer enabled);
}
