package main;

import dao.jdbc.CityImpl;

public class Main {

	public static void main(String[] args) {


		
		CityImpl impl = new CityImpl();
		System.out.println(impl.readEntityById(1));
		
	}

}
