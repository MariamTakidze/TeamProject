package main;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.jdbc.CityImpl;
import dao.jdbc.DistanceImpl;
import dao.jdbc.StationImpl;
import dao.jdbc.TransportImpl;
import models.City;
import models.Distance;
import models.Station;
import models.Transport;
import mybatisdao.CityDAO;
import mybatisdao.ITransportDAO;
import mybatisdao.TransportDAO;
import utils.FloydWarshall;

public class Main {
	
	
	
	public static void main(String[] args) {


		FloydWarshall warsh = new FloydWarshall();
		

		
		warsh.run();
	
		
	
	
	
	
	}

}
