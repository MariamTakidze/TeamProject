package mybatisdao;

import java.util.ArrayList;

import models.Station;

public interface IStationDAO {
	ArrayList<Station> getAllStations();
	Station getStation(long id);
	public void create(Station station);
	public void update(Station station);
	public void delete(Station station);
}
