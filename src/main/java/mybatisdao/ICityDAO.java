package mybatisdao;

import java.util.ArrayList;

import models.City;

public interface ICityDAO {
	public ArrayList<City >getAllCities();
	public City getCity(long id);
}
