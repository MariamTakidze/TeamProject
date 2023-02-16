package main;

import java.util.List;

import dao.jdbc.DistanceImpl;
import dao.jdbc.StationImpl;
import models.Distance;
import models.Station;
import utils.FloydWarshall;

public class Main {

	public static void main(String[] args) {


		
		FloydWarshall warsh = new FloydWarshall();
		
		Integer[][] distances =warsh.calculateMatrix();
		
		
		for (int i = 0; i < distances.length; i++) {
			for (int j = 0; j < distances[i].length; j++) {
				System.out.println(distances[i][j]);
			}
		}
		
		
		
		DistanceImpl dimpl = new DistanceImpl();
		
//		System.out.println(dimpl.readEntityByIds(1, 2).getDistance());
//		Distance dist = new Distance(7,7,0);
		//dimpl.insertEntity(dist);
		//dimpl.deleteEntityByIds(7, 7);
//		dimpl.updateEntityById(7, 7 ,dist);
//		List<Distance> dists=dimpl.getALLEntities();
//		for (Distance distance : dists) {
//			System.out.println(distance);
//		}
		
		
		
//		StationImpl simpl = new StationImpl();
		
		//System.out.println(simpl.readEntityById(2));
//		Station station = new Station(15,"aaaaa",2);
//		simpl.insertEntity(station);
//		simpl.updateEntityById(15, station);
//		simpl.deleteEntityById(15);
//		List<Station> stats=simpl.getALLEntities();
//		for (Station station2 : stats) {
//			System.out.println(station2);
//		}
//		System.out.println(simpl.getEntityByName("didube"));
		
//		CityImpl impl = new CityImpl();
//		System.out.println(impl.readEntityById(1));
		
//		City cityTest=new City(3,"Tbilisi");
		//impl.insertEntity(cityTest);
//		impl.updateEntityById(3, cityTest);
		//impl.deleteEntityById(4);
//		List<City> cit =impl.getALLEntities();
//		for(City ci :cit) {
//			System.out.println(ci.getIdCity());
//			System.out.println(ci.getName());
//		}
		
		
		
//		TransportImpl timpl = new TransportImpl();
//		System.out.println(timpl.readEntityById(2));
//		Transport trans = new Transport(5,"bus",60);
//		timpl.updateEntityById(2, trans);
//		timpl.insertEntity(trans);
//		timpl.deleteEntityById(5);
//		List<Transport> transps =timpl.getALLEntities();
//		
//		for (Transport transport : transps) {
//			System.out.println(transport);
//		}
//		System.out.println(timpl.getEntityByType("car"));
		
		
		
		
		
	}

}
