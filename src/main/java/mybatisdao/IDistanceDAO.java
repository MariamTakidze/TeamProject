package mybatisdao;

import java.util.ArrayList;

import models.Distance;

public interface IDistanceDAO {
	ArrayList<Distance> getAllDistances();
	Distance getDistance(Distance distance);
}
