package utils;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.jdbc.DistanceImpl;
import dao.jdbc.StationImpl;
import dao.jdbc.TransportImpl;
import models.Station;
import models.Transport;

public class FloydWarshall {
	
	private static final Logger LOGGER = LogManager.getLogger(FloydWarshall.class);
	StationImpl sImpl = new StationImpl();
	DistanceImpl dImpl = new DistanceImpl();
	
	
	public int[][] generateMatrix() {

		int length = sImpl.getALLEntities().size();
		
		int[][] distances = new int[length][length];
		
			for (int i = 1; i <= length; i++) {
				for (int j = 1; j <= length; j++) {
						distances[i-1][j-1] =((dImpl.readEntityByIds(i, j).getDistance()));
				}	
			}
		
		return distances;
	}
	
	
	public int[][] calculateMatrix(){
		int[][] matr = generateMatrix();
		
		for (int k = 0; k < matr.length; k++) {
			for (int i = 0; i < matr.length; i++) {
				for (int j = 0; j < matr.length; j++) {
					matr[i][j]=Math.min(matr[i][j], (matr[i][k])+matr[j][k]);
				}
			}
		}
		
		return matr;
	}
	
	public void getShortestDistance(Station from,Station to, Transport transport) {
			
			int[][] distances = calculateMatrix();
			
			int distance = distances[from.getIdStation()][to.getIdStation()];
			int time = 0;
			
			
			LOGGER.debug("You are going from "+ from.getName() + " to "+to.getName()+ " shortest distance is " + distance + "kilometer and with "
						+transport.getType()+" you will need "+ time +" minutes to reach it ");
		}
	public void getDistanceAndTime(String from,String to, String transport) {
		
		int[][] distances = calculateMatrix();

		
		StationImpl stationImpl = new StationImpl();
		Station statFrom = stationImpl.getEntityByName(from);
		Station statTo = stationImpl.getEntityByName(to);
		
		TransportImpl transp = new TransportImpl();
		Transport transpDatabase = transp.getEntityByType(transport);
		
		
		int fromId =statFrom.getIdStation();
		int toId =statTo.getIdStation();
		
		double shortestDistance = distances[(fromId -1)][(toId -1)];
		double speed = transpDatabase.getSpeed();
		
		int time = (int) ((shortestDistance/speed)*60);
		
		
		if(shortestDistance<999999) {
			LOGGER.info("you are going from "+statFrom.getName()+" to "+statTo.getName()+" and shortest distance between"
				+ " this two stations is "+ shortestDistance+"km. estimated arrival time with "+transpDatabase.getType()+" is "
				+time+" minute");
		}else {
			LOGGER.info("between "+statFrom.getName()+" and "+ statTo.getName()+ "there is no connection");
		}
		
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		LOGGER.info("please type the station name you want to go from: ");
		String from =scanner.next().toLowerCase();
		
		LOGGER.info("please type the station name you want to go to: ");
		String to =scanner.next().toLowerCase();
		
		LOGGER.info("please type the transport type you plan to go with: ");
		String transport =scanner.next().toLowerCase();
		
		getDistanceAndTime(from,to,transport);
	}
	
}
