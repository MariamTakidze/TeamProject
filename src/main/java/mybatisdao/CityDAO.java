package mybatisdao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.City;

public class CityDAO implements ICityDAO {
	private static Logger LOGGER = LogManager.getLogger(CityDAO.class);
	
	@Override
	public ArrayList<City> getAllCities() {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		ArrayList<City> cities = null;
        try{
            ICityDAO iCityDAO = sqlSession.getMapper(ICityDAO.class);
            cities = iCityDAO.getAllCities();
        } catch(Exception e) {
        	sqlSession.rollback();
        	LOGGER.error(e);
        }
        finally {
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
        	sqlSession.rollback();
        	LOGGER.error(e);
        } finally {
            sqlSession.close();
        }
        
        return city;
	}

	@Override
	public void create(City city) {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		
        try{
    		ICityDAO iCityDAO = sqlSession.getMapper(ICityDAO.class);
    		iCityDAO.create(city);
    		sqlSession.commit();
    		LOGGER.info("City record created");
        } catch(Exception e) {
        	sqlSession.rollback();
        	LOGGER.error(e);
        } finally {
            sqlSession.close();
        }
		
	}

	@Override
	public void update(City city) {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		
        try{
    		ICityDAO iCityDAO = sqlSession.getMapper(ICityDAO.class);
    		iCityDAO.update(city);
    		sqlSession.commit();
    		LOGGER.info("City record updated");
        } catch(Exception e) {
        	sqlSession.rollback();
        	LOGGER.error(e);
        } finally {
            sqlSession.close();
        }
		
	}

	@Override
	public void delete(City city) {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		
        try{
    		ICityDAO iCityDAO = sqlSession.getMapper(ICityDAO.class);
    		iCityDAO.delete(city);
    		sqlSession.commit();
    		LOGGER.info("City record deleted");
        } catch(Exception e) {
        	sqlSession.rollback();
        	LOGGER.error(e);
        } finally {
            sqlSession.close();
        }
		
	}
}
