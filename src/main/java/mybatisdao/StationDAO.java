package mybatisdao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import models.City;
import models.Station;

public class StationDAO {
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
}
