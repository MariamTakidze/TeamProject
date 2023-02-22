package mybatisdao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.Transport;

public class TransportDAO implements ITransportDAO {
	private static Logger LOGGER = LogManager.getLogger(TransportDAO.class);
	
	@Override
	public ArrayList<Transport> getAllTransports() {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		ArrayList<Transport> transports = null;
        try{
            ITransportDAO iTransportDAO = sqlSession.getMapper(ITransportDAO.class);
            transports = iTransportDAO.getAllTransports();
        } catch(Exception e) {
        	LOGGER.error(e);
        } finally {
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
        	LOGGER.error(e);
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
        
        return transport;
	}

	@Override
	public void create(Transport transport) {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		
        try{
    		ITransportDAO iTransportDAO = sqlSession.getMapper(ITransportDAO.class);
    		iTransportDAO.create(transport);
    		sqlSession.commit();
    		LOGGER.info("Transport record created");
        } catch(Exception e) {
        	sqlSession.rollback();
        	LOGGER.error(e);
        } finally {
            sqlSession.close();
        }
	}

	@Override
	public void update(Transport transport) {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
		
        try{
    		ITransportDAO iTransportDAO = sqlSession.getMapper(ITransportDAO.class);
    		iTransportDAO.update(transport);
    		sqlSession.commit();
    		LOGGER.info("Transport record updated");
        } catch(Exception e) {
        	sqlSession.rollback();
        	LOGGER.error(e);
        } finally {
            sqlSession.close();
        }
	}

	@Override
	public void delete(Transport transport) {
		SqlSession sqlSession = MyBatis.getSqlSessionFactory().openSession();
        try{
    		ITransportDAO iTransportDAO = sqlSession.getMapper(ITransportDAO.class);
    		iTransportDAO.delete(transport);
    		sqlSession.commit();
    		LOGGER.info("Transport record deleted");
        } catch(Exception e) {
        	sqlSession.rollback();
        	LOGGER.error(e);
        } finally {
            sqlSession.close();
        }
	}
}
