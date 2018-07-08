package com.hkbea.data.mapper;

import org.apache.ibatis.annotations.SelectProvider;

import com.hkbea.data.mapper.provider.PrivilegeProvider;
import com.hkbea.data.model.SysPrivilege;

public interface PrivilegeMapper {

	@SelectProvider(method = "selectById", type = PrivilegeProvider.class)
	SysPrivilege selectById(Long id);
}
