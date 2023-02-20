package mybatisdao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import models.City;

public class CityDAO implements ICityDAO {
	@Override
	public ArrayList<City> getAllCities() {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		ArrayList<City> cities = null;
        try{
            ICityDAO iCityDAO = sqlSession.getMapper(ICityDAO.class);
            cities = iCityDAO.getAllCities();
        } catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        finally {
            sqlSession.rollback();
            sqlSession.close();
        }
        
        return cities;
	}
	
	@Override
	public City getCity(long id) {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		City city = null;
		
        try{
            ICityDAO iCityDAO = sqlSession.getMapper(ICityDAO.class);
            city = iCityDAO.getCity(id);
        } catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        finally {
            sqlSession.rollback();
            sqlSession.close();
        }
        
        return city;
	}
}
