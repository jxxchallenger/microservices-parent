package com.hkbea.data.mapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hkbea.data.model.Language;

public class LanguageMapperTest extends BaseMapperTest{

	@Test(priority = 1)
	public void testCreateTable(){
		SqlSession session = getSqlSession();
		
		try {
			LanguageMapper mapper = session.getMapper(LanguageMapper.class);
			mapper.createTable();
			
			session.commit();
		} finally {
			session.close();
		}
	}
	
	@DataProvider(name = "languageList")
	public Object[][] getLanguageList(){
		
		String languagePath = System.getProperty("user.dir") + "\\src\\test\\resources\\LangList.xml";
		
		SAXReader reader = new SAXReader();
		
		Document document = null;
		
		try(Reader reader2 = new FileReader(languagePath)){
			try {
				document = reader.read(reader2);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			reader2.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		List<Language> languages = new ArrayList<Language>();
		
		Element element = document.getRootElement();
		
		for(Iterator<Element> it = element.elementIterator("Language"); it.hasNext();){
			Element e = it.next();
			
			Language language = new Language(Integer.parseInt(e.attributeValue("LCID")), e.attributeValue("Name"), e.attributeValue("Code"));
			
			languages.add(language);
		}
		
		
		return new Object[][]{{"languageList", languages}};
	}
	
	@Test(priority = 2, dataProvider = "languageList")
	public void testBatchInsert(String name, List<Language> languages){
		SqlSession session = getSqlSession();
		
		try {
			LanguageMapper mapper = session.getMapper(LanguageMapper.class);
			int count = mapper.batchInsert(languages);
			session.commit();
			
			Assert.assertTrue(count > 0);
		} finally {
			session.close();
		}
	}
}
