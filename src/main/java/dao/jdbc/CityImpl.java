package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ICity;
import models.City;
import utils.ConnectionPool;

public class CityImpl implements ICity {
	
	 private static final Logger LOGGER = LogManager.getLogger(CityImpl.class);


	ConnectionPool conPool = ConnectionPool.getinstance();

	
	
	@Override
	public City readEntityById(int id) {

		Connection connection = conPool.retrieve();
		City city = null;
		
		String query = "SELECT * FROM city WHERE id_city=?";
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(query);
			
		ps.setInt(1, id);
		
		 rs = ps.executeQuery();
		if(rs.next()) {
			int cityid = rs.getInt(1);
			String name = rs.getString(2);
			
			city = new City(cityid,name);
		}

		} catch (SQLException e) {
			LOGGER.error(e);
		}finally {
			if(rs !=null)
				try {
					rs.close();
					LOGGER.info("ResultSet closed succesfully");
				} catch (SQLException e) {
					LOGGER.error(e);
			}
			if(ps != null) {
				try {
					ps.close();
					LOGGER.info("PreparedStarement closed succesfully");
				} catch (SQLException e) {
					LOGGER.error(e);
				}
			}
			
			if(connection != null)
			{
				conPool.putback(connection);
				LOGGER.info("Connection putback is successfull");
			}
		}
		return city;	


	}

	@Override
	public void updateEntityById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertEntity(City t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEntityById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<City> getALLEntities() {
		// TODO Auto-generated method stub
		return null;
	}

}
