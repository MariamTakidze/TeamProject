package mybatisdao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.City;
import models.Station;

public class StationDAO implements IStationDAO {
	private static Logger LOGGER = LogManager.getLogger(TransportDAO.class);
	
	public ArrayList<Station> getAllStations() {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		ArrayList<Station> stations = null;
        try{
            IStationDAO iStationDAO = sqlSession.getMapper(IStationDAO.class);
            stations = iStationDAO.getAllStations();
        } catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        finally {
            sqlSession.rollback();
            sqlSession.close();
        }
        
        return stations;
	}
	
	public Station getStation(long id) {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		Station station = null;
        try{
            IStationDAO iStationDAO = sqlSession.getMapper(IStationDAO.class);
            station = iStationDAO.getStation(id);
        } catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        finally {
            sqlSession.rollback();
            sqlSession.close();
        }
        
        return station;
	}
	
	public void create(Station station) {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		
        try{
    		IStationDAO iStationDAO = sqlSession.getMapper(IStationDAO.class);
    		iStationDAO.create(station);
    		sqlSession.commit();
    		LOGGER.info("Station record created");
        } catch(Exception e) {
        	sqlSession.rollback();
        	LOGGER.error(e);
        } finally {
            sqlSession.close();
        }
	}

	@Override
	public void update(Station station) {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		
        try{
    		IStationDAO iStationDAO = sqlSession.getMapper(IStationDAO.class);
    		iStationDAO.update(station);
    		sqlSession.commit();
    		LOGGER.info("Station record updated");
        } catch(Exception e) {
        	sqlSession.rollback();
        	LOGGER.error(e);
        } finally {
            sqlSession.close();
        }
	}

	@Override
	public void delete(Station station) {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		
        try{
    		IStationDAO iStationDAO = sqlSession.getMapper(IStationDAO.class);
    		iStationDAO.delete(station);
    		sqlSession.commit();
    		LOGGER.info("Station record deleted");
        } catch(Exception e) {
        	sqlSession.rollback();
        	LOGGER.error(e);
        } finally {
            sqlSession.close();
        }
	}
}
