package com.hkbea.data.xml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Foo {

	private static final String LOC_LIST = System.getProperty("user.dir") + "\\src\\test\\resources\\LocList.xml";
	
	private Document document;
	
	@BeforeClass
	public void init(){
		SAXReader reader = new SAXReader();
		
		
		try(Reader reader2 = new FileReader(LOC_LIST)){
			try {
				this.document = reader.read(reader2);
			} catch (DocumentException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testXml(){
		Element root = this.document.getRootElement();
		
		List<CountryRegion> countryRegionList = new ArrayList<CountryRegion>();
		
		long crId = 100000000;
		long stateId = 100000000;
		long cityId = 100000000;
		long regionId = 100000000;
		
		for(Iterator<Element> crs = root.elementIterator("CountryRegion"); crs.hasNext();){
			Element countryRegion = crs.next();
			String crName = countryRegion.attributeValue("Name");
			String crCode = countryRegion.attributeValue("Code");
			
			CountryRegion cr = new CountryRegion(crName, crCode);
			Set<State> stateSet = new HashSet<State>();
			
			for(Iterator<Element> states = countryRegion.elementIterator("State"); states.hasNext();){
				Element state = states.next();
				String sName = state.attributeValue("Name");
				String sCode = state.attributeValue("Code");
				
				State st = new State(sName, sCode);
				Set<City> citySet = new HashSet<City>();
				
				for(Iterator<Element> cities = state.elementIterator("City"); cities.hasNext();){
					Element city = cities.next();
					
					String cName = city.attributeValue("Name");
					String cCode = city.attributeValue("Code");
					
					City ct = new City(cName, cCode);
					Set<Region> regionSet = new HashSet<Region>();
					
					for(Iterator<Element> regions = city.elementIterator("Region"); regions.hasNext();){
						Element region = regions.next();
						String rName = region.attributeValue("Name");
						String rCode = region.attributeValue("Code");
						
						Region rg = new Region(rName, rCode);
						
						regionSet.add(rg);
					}
					
					citySet.add(ct);
				}
				
				st.setCities(citySet);
				
				stateSet.add(st);
				
			}
			cr.setStates(stateSet);
			countryRegionList.add(cr);
		}
		
		System.out.println(countryRegionList.size());
	}
}
