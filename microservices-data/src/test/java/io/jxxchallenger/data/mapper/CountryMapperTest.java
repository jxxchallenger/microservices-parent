package io.jxxchallenger.data.mapper;

import org.testng.annotations.Test;

import io.jxxchallenger.data.model.Country;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.AfterClass;

public class CountryMapperTest extends BaseMapperTest{

	@Test
	public void f() {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Country> countries = session.selectList("io.jxxchallenger.data.mapper.CountryMapper.selectAll");
			for(Country country:countries){
				System.out.printf("%-4d%4s%4s\n", country.getId(), country.getCountryname(), country.getCountrycode());
			}
		} finally {
			session.close();
		}
	}


	@AfterClass
	public void afterClass() {
		
	}

}
