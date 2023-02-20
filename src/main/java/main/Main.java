package main;

import java.util.List;

import dao.jdbc.CityImpl;
import dao.jdbc.DistanceImpl;
import dao.jdbc.StationImpl;
import dao.jdbc.TransportImpl;
import models.City;
import models.Distance;
import models.Station;
import models.Transport;
import utils.FloydWarshall;

public class Main {

	public static void main(String[] args) {


		
		Transport transport = new Transport(5,"bus",60);
		
		StationImpl stationImpl = new StationImpl();
		
		Station st1 = stationImpl.readEntityById(2);
		Station st2 = stationImpl.readEntityById(1);
		
		FloydWarshall warsh = new FloydWarshall();
		
		warsh.getShortestDistance(st1 , st2, transport);
		
//		Integer[][] warshDistances = warsh.calculateMatrix();
//		
//		
//		for (int i = 0; i < warshDistances.length; i++) {
//			for (int j = 0; j < warshDistances[i].length; j++) {
//				System.out.print(warshDistances[i][j]+" ");
//			}
//		}
		
		
		
//		DistanceImpl distanceImpl = new DistanceImpl();
//		
//		System.out.println(distanceImpl.readEntityByIds(1, 2).getDistance());
//		Distance distance = new Distance(7,7,0);
//		distanceImpl.insertEntity(distance);
//		distanceImpl.deleteEntityByIds(7, 7);
//		distanceImpl.updateEntityById(7, 7 ,distance);
//		List<Distance> distances = distanceImpl.getALLEntities();
//		for (Distance dist : distances) {
//			System.out.println(dist);
//		}
//		
//		
//		
//		StationImpl stationImpl = new StationImpl();
//		
//		System.out.println(stationImpl.readEntityById(2));
//		Station station = new Station(15,"aaaaa",2);
//		stationImpl.insertEntity(station);
//		stationImpl.updateEntityById(15, station);
//		stationImpl.deleteEntityById(15);
//		List<Station> stations = stationImpl.getALLEntities();
//		for (Station st : stations) {
//			System.out.println(st);
//		}
//		System.out.println(stationImpl.getEntityByName("didube"));
//		
//		CityImpl cityImpl = new CityImpl();
//		System.out.println(cityImpl.readEntityById(1));
//		
//		City cityTest=new City(3,"Tbilisi");
//		cityImpl.insertEntity(cityTest);
//		cityImpl.updateEntityById(3, cityTest);
//		cityImpl.deleteEntityById(4);
//		List<City> citys =cityImpl.getALLEntities();
//		for(City city :citys) {
//			System.out.println(city.getIdCity());
//			System.out.println(city.getName());
//		}
//		
//		
//		
//		TransportImpl transportImpl = new TransportImpl();
//		System.out.println(transportImpl.readEntityById(2));
//		Transport transport = new Transport(5,"bus",60);
//		transportImpl.updateEntityById(2, transport);
//		transportImpl.insertEntity(transport);
//		transportImpl.deleteEntityById(5);
//		List<Transport> transports =transportImpl.getALLEntities();
//		
//		for (Transport tr : transports) {
//			System.out.println(tr);
//		}
//		System.out.println(transportImpl.getEntityByType("car"));
//		
		
		
		
		
	}

}
