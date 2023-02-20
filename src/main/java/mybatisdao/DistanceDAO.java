package mybatisdao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import models.Distance;

public class DistanceDAO implements IDistanceDAO {

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

}
