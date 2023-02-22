package mybatisdao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.Distance;

public class DistanceDAO implements IDistanceDAO {
	private static Logger LOGGER = LogManager.getLogger(TransportDAO.class);
	
	@Override
	public ArrayList<Distance> getAllDistances() {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		ArrayList<Distance> distances = null;
        try{
            IDistanceDAO iDistanceDAO = sqlSession.getMapper(IDistanceDAO.class);
            distances = iDistanceDAO.getAllDistances();
        } catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        finally {
            sqlSession.rollback();
            sqlSession.close();
        }
        
        return distances;
	}

	@Override
	public Distance getDistance(Distance distanceArg) {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		Distance distance = null;
        try{
        	IDistanceDAO iDistanceDAO = sqlSession.getMapper(IDistanceDAO.class);
            distance = iDistanceDAO.getDistance(distanceArg);
        } catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        finally {
            sqlSession.rollback();
            sqlSession.close();
        }
        
        return distance;
	}

	@Override
	public void create(Distance distance) {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		
        try{
    		IDistanceDAO iDistanceDAO = sqlSession.getMapper(IDistanceDAO.class);
    		iDistanceDAO.create(distance);
    		sqlSession.commit();
    		LOGGER.info("Distance record created");
        } catch(Exception e) {
        	sqlSession.rollback();
        	LOGGER.error(e);
        } finally {
            sqlSession.close();
        }
	}

	@Override
	public void update(Distance distance) {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		
        try{
    		IDistanceDAO iDistanceDAO = sqlSession.getMapper(IDistanceDAO.class);
    		iDistanceDAO.update(distance);
    		sqlSession.commit();
    		LOGGER.info("Distance record created");
        } catch(Exception e) {
        	sqlSession.rollback();
        	LOGGER.error(e);
        } finally {
            sqlSession.close();
        }
	}

	@Override
	public void delete(Distance distance) {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		
        try{
    		IDistanceDAO iDistanceDAO = sqlSession.getMapper(IDistanceDAO.class);
    		iDistanceDAO.delete(distance);
    		sqlSession.commit();
    		LOGGER.info("Distance record created");
        } catch(Exception e) {
        	sqlSession.rollback();
        	LOGGER.error(e);
        } finally {
            sqlSession.close();
        }
	}

}
