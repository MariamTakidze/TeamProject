package dao;

import java.util.List;

import models.Distance;

public interface IDistance   {
	Distance readEntityByIds(int id, int id2);
	
	void updateEntityById(int id,int id2);
	
	void insertEntity(Distance distance);
	
	void deleteEntityByIds(int id,int id2);
	
	List<Distance> getALLEntities();
}
