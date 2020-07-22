package io.jxxchallenger.data.mapper.provider;

import org.apache.ibatis.jdbc.SQL;

public class PrivilegeProvider {

	public String selectById(final Long id){
		
		return new SQL(){
			{
				SELECT("id, privilege_name, privilege_url");
				FROM("sys_privilege");
				WHERE("id = #{id}");
			}
		}.toString();
	}
}
