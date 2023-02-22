package mybatisdao;

import java.util.ArrayList;

import models.Distance;

public interface IDistanceDAO {
	ArrayList<Distance> getAllDistances();
	Distance getDistance(Distance distance);
	public void create(Distance distance);
	public void update(Distance distance);
	public void delete(Distance distance);
}
