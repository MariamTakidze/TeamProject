package dao;

import models.Station;

public interface IStation extends IBaseDao<Station> {
	Station getEntityByName();
}
