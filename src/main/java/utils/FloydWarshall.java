package utils;

import dao.jdbc.DistanceImpl;
import dao.jdbc.StationImpl;

public class FloydWarshall {
	
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
	
	
}
