package io.jxxchallenger.data.mapper;

import org.apache.ibatis.annotations.SelectProvider;

import io.jxxchallenger.data.mapper.provider.PrivilegeProvider;
import io.jxxchallenger.data.model.SysPrivilege;

public interface PrivilegeMapper {

	@SelectProvider(method = "selectById", type = PrivilegeProvider.class)
	SysPrivilege selectById(Long id);
}
