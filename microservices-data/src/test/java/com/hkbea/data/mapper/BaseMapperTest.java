package com.hkbea.data.mapper;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.BeforeClass;

public abstract class BaseMapperTest {

	protected static SqlSessionFactory sqlSessionFactory;
	
	@BeforeClass
	public static void init(){
		
		try{
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	protected SqlSession getSqlSession(){
		return sqlSessionFactory.openSession();
	}
}
