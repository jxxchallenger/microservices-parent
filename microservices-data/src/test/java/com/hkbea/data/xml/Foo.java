package com.hkbea.data.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
	
	//private Document document;
	
	private List<CountryRegion> countryRegions;
	
	@BeforeClass
	public void init(){
		SAXReader reader = new SAXReader();
		
		Document document = null;
		
		try(Reader reader2 = new FileReader(LOC_LIST)){
			try {
				document = reader.read(reader2);
			} catch (DocumentException e) {
				
				e.printStackTrace();
			}
			reader2.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		Element root = document.getRootElement();
		
		List<CountryRegion> countryRegionList = new ArrayList<CountryRegion>();
		
		int crId = 100;
		
		
		
		
		for(Iterator<Element> crs = root.elementIterator("CountryRegion"); crs.hasNext();){
			Element countryRegion = crs.next();
			String crName = countryRegion.attributeValue("Name");
			String crCode = countryRegion.attributeValue("Code");
			
			int country_id = crId * 1000000;
			
			CountryRegion cr = new CountryRegion(country_id, crName, crCode);
			
			Set<State> stateSet = new HashSet<State>();
			
			int stateId = 1;
			
			for(Iterator<Element> states = countryRegion.elementIterator("State"); states.hasNext();){
				Element state = states.next();
				String sName = state.attributeValue("Name");
				String sCode = state.attributeValue("Code");
				if(null == sName || sName.trim().length() == 0){
					sName = crName;
					sCode = crCode;
				}
				
				int state_id = crId * 1000000  + stateId * 10000;
				State st = new State(state_id, sName, sCode);
				st.setParentId(country_id);
				Set<City> citySet = new HashSet<City>();
				
				int cityId = 1;
				
				for(Iterator<Element> cities = state.elementIterator("City"); cities.hasNext();){
					Element city = cities.next();
					
					String cName = city.attributeValue("Name");
					String cCode = city.attributeValue("Code");
					
					int city_id = state_id + cityId * 100;
					City ct = new City(city_id, cName, cCode);
					ct.setParentId(state_id);
					
					Set<Region> regionSet = new HashSet<Region>();
					
					int regionId = 1;
					for(Iterator<Element> regions = city.elementIterator("Region"); regions.hasNext();){
						Element region = regions.next();
						String rName = region.attributeValue("Name");
						String rCode = region.attributeValue("Code");
						
						int region_id = city_id + regionId;
						Region rg = new Region(region_id, rName, rCode);
						rg.setParentId(city_id);
						
						regionSet.add(rg);
						regionId++;
					}
					//if(regionSet.size() > 0){
						ct.setRegions(regionSet);
					//}
					citySet.add(ct);
					
					cityId++;
				}
				
				st.setCities(citySet);
				
				stateSet.add(st);
				
				stateId++;
			}
			cr.setStates(stateSet);
			countryRegionList.add(cr);
			
			crId++;
		}
		
		this.countryRegions = countryRegionList;
		System.out.println(countryRegionList.size());
	}
	
	
	
	@Test(priority = 1)
	public void testCountryRegion(){
		/*StringBuilder sb = new StringBuilder();
		
		countryRegions.forEach(cr -> {
			sb.append("INSERT INTO country_region(id, short_name_cn, code) values(");
			sb.append(cr.getId());
			sb.append(", '");
			sb.append(cr.getName());
			sb.append("', '");
			sb.append(cr.getCode());
			sb.append("');\n");
			
		});*/
		String countryRegionPath = System.getProperty("user.dir") + File.separatorChar + "src\\test\\resources\\CountryRegion.sql";
		
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(countryRegionPath, true))){
				for(CountryRegion cr:countryRegions){
					
					bw.write("INSERT INTO country_region(id, short_name_cn, code) VALUES(" + cr.getId() + ", '" + cr.getName() + "', '" + cr.getCode() + "');");
					bw.newLine();
					
					if(cr.getStates().size() > 0){
						testState(cr.getStates(), cr.getId());
					}
					
				}
				bw.flush();
				bw.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		
		
	}
	
	private void testState(Set<State> states, int parentId){
		String statePath = System.getProperty("user.dir") + File.separatorChar + "src\\test\\resources\\State.sql";
		try(BufferedWriter bwState = new BufferedWriter(new FileWriter(statePath, true))){
			for(State state:states){
				bwState.write("INSERT INTO state(id, name, code, cr_id) VALUES(" + state.getId() + ", '" + state.getName() + "', '" + state.getCode() + "', " + parentId + ");");
				bwState.newLine();
				
				if(state.getCities().size() > 0){
					testCity(state.getCities(), state.getId());
				}
			}
			
			bwState.flush();
			bwState.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void testCity(Set<City> cities, int parentId){
		String cityPath = System.getProperty("user.dir") + File.separatorChar + "src\\test\\resources\\City.sql";
		
		try(BufferedWriter bwCity = new BufferedWriter(new FileWriter(cityPath, true))){
			
			for(City city:cities){
				bwCity.write("INSERT INTO city(id, name, code, state_id) VALUES(" + city.getId() + ", '" + city.getName() + "', '" + city.getCode() + "', " + parentId + ");");
				bwCity.newLine();
				
				if(city.getRegions().size() > 0){
					testRegion(city.getRegions(), city.getId());
				}
			}
			
			bwCity.flush();
			bwCity.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void testRegion(Set<Region> regions, int parentId){
		String regionPath = System.getProperty("user.dir") + File.separatorChar + "src\\test\\resources\\Region.sql";
		
		try(BufferedWriter bwRegion = new BufferedWriter(new FileWriter(regionPath, true))){
			
			for(Region region:regions){
				bwRegion.write("INSERT INTO region(id, name, code, city_id) VALUES(" + region.getId() + ", '" + region.getName() + "', '" + region.getCode() + "', " + parentId + ");");
				bwRegion.newLine();
			}
			
			bwRegion.flush();
			bwRegion.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
