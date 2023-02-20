package mybatisdao;

import java.util.ArrayList;

import models.Station;

public interface IStationDAO {
	ArrayList<Station> getAllStations();
	Station getStation(long id);
}
