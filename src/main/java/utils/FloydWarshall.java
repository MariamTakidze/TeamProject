package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.jdbc.DistanceImpl;
import dao.jdbc.StationImpl;
import models.Station;
import models.Transport;

public class FloydWarshall {
	
	private static final Logger LOGGER = LogManager.getLogger(FloydWarshall.class);
	StationImpl sImpl = new StationImpl();
	DistanceImpl dImpl = new DistanceImpl();
	
	
	public Integer[][] generateMatrix() {

		int length = sImpl.getALLEntities().size();
		
		Integer[][] distances = new Integer[length][length];
		
			for (int i = 1; i <= length; i++) {
				for (int j = 1; j <= length; j++) {
						distances[i-1][j-1] =((dImpl.readEntityByIds(i, j).getDistance()));
				}	
			}
		
		return distances;
	}
	
	
	public Integer[][] calculateMatrix(){
		Integer[][] matr = generateMatrix();
		
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
			
			Integer[][] distances = calculateMatrix();
			
			int distance = distances[from.getIdStation()][to.getIdStation()];
			int time = 0;
			
			
			LOGGER.info("You are going from "+ from.getName() + " to "+to.getName()+ " shortest distance is " + distance + "kilometer and with "
						+transport.getType()+" you will need "+ time +" minutes to reach it ");
		}

	
}
