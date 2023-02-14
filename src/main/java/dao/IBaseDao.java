package dao;

import java.util.List;

public interface IBaseDao<T> {
	T readEntityById(int id);
	
	void updateEntityById(int id,T t);
	
	void insertEntity(T t);
	
	void deleteEntityById(int id);
	
	List<T> getALLEntities();
}
