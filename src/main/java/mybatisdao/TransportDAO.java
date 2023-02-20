package mybatisdao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import models.Transport;

public class TransportDAO implements ITransportDAO {

	@Override
	public ArrayList<Transport> getAllTransports() {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		ArrayList<Transport> transports = null;
        try{
            ITransportDAO iTransportDAO = sqlSession.getMapper(ITransportDAO.class);
            transports = iTransportDAO.getAllTransports();
        } catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        finally {
            sqlSession.rollback();
            sqlSession.close();
        }
        
        return transports;
	}

	@Override
	public Transport getTransport(long id) {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		Transport transport = null;
		
        try{
        	ITransportDAO iTransportDAO = sqlSession.getMapper(ITransportDAO.class);
            transport = iTransportDAO.getTransport(id);
        } catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        finally {
            sqlSession.rollback();
            sqlSession.close();
        }
        
        return transport;
	}
}
