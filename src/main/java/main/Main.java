package main;

import java.util.Iterator;
import java.util.List;

import dao.jdbc.CityImpl;
import models.City;

public class Main {

	public static void main(String[] args) {


		
		CityImpl impl = new CityImpl();
//		System.out.println(impl.readEntityById(1));
		
		City cityTest=new City(3,"Tbilisi");
		//impl.insertEntity(cityTest);
		impl.updateEntityById(3, cityTest);
		//impl.deleteEntityById(4);
//		List<City> cit =impl.getALLEntities();
//		for(City ci :cit) {
//			System.out.println(ci.getIdCity());
//			System.out.println(ci.getName());
//		}
	}

}
