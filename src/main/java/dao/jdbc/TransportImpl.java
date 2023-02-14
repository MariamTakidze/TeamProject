package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ITransport;
import models.Transport;
import utils.ConnectionPool;

public class TransportImpl implements ITransport {

	 private static final Logger LOGGER = LogManager.getLogger(TransportImpl.class);

	
	ConnectionPool conPool = ConnectionPool.getinstance();

	
	@Override
	public Transport readEntityById(int id) {
		Connection connection = conPool.retrieve();
		Transport transport = null;
		
		String query = "SELECT * FROM transport WHERE transport_id=?";
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(query);
			
		ps.setInt(1, id);
		
		 rs = ps.executeQuery();
		if(rs.next()) {
			int transportid = rs.getInt(1);
			String type = rs.getString(2);
			int speed = rs.getInt(3);
			
			transport = new Transport(transportid,type,speed);
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
		return transport;	
	}

	@Override
	public void updateEntityById(int id, Transport transport) {
		
		Connection connection = conPool.retrieve();
		
		String query = "UPDATE  transport SET  type=?, speed=? WHERE transport_id=?";
		PreparedStatement ps = null;
		
		

		try {
			ps=connection.prepareStatement(query);
			ps.setString(1,transport.getType());
			ps.setInt(2, transport.getSpeed());
			ps.setInt(3, id);


			

			ps.execute();
			LOGGER.info("transport successfully updated");

		}catch(SQLException e){
			LOGGER.error(e);
		}finally {
			if(ps != null) {
				try {
					ps.close();
					LOGGER.info("PreparedStatement closed succesfully");

				}catch(SQLException e) {
					LOGGER.error(e);
				}
			}
			if(connection != null) {
				conPool.putback(connection);
				LOGGER.info("Connection putback is successfull");
				}
		}
		
	}

	@Override
	public void insertEntity(Transport t) {
		Connection connection = conPool.retrieve();
		
		String query = "INSERT INTO transport VALUES(?,?,?)";
		PreparedStatement ps = null;
		
		
		try {
			ps=connection.prepareStatement(query);
			ps.setInt(1, t.getIdTransport());
			ps.setString(2,t.getType());
			ps.setInt(3,t.getSpeed());

			ps.execute();
			LOGGER.info("transport successfully inserted");

		}catch(SQLException e){
			LOGGER.error(e);
		}finally {
			if(ps != null) {
				try {
					ps.close();
					LOGGER.info("PreparedStatement closed succesfully");

				}catch(SQLException e) {
					LOGGER.error(e);
				}
			}
			if(connection != null) {
				conPool.putback(connection);
				LOGGER.info("Connection putback is successfull");
			}
		}
		
	}

	@Override
	public void deleteEntityById(int id) {
		Connection connection = conPool.retrieve();
		String query = "DELETE FROM transport WHERE transport_id=?";
		PreparedStatement ps = null;


		try {
			ps=connection.prepareStatement(query);
			ps.setLong(1, id);
			

			ps.execute();
			LOGGER.info("transport successfully deleted");

		}catch(SQLException e){
			LOGGER.error(e);
		}finally {
			if(ps != null) {
				try {
					ps.close();
					LOGGER.info("PreparedStatement closed succesfully");

				}catch(SQLException e) {
					LOGGER.error(e);
				}
			}
			if(connection != null) {
				conPool.putback(connection);
				LOGGER.info("Connection putback is successfull");
				}
		}
		
	}

	@Override
	public List<Transport> getALLEntities() {
		Connection connection = conPool.retrieve();
		List<Transport> transports = new ArrayList<>();
		
		String query = "SELECT * FROM transport ";
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(query);

		 rs =  ps.executeQuery();
		 while(rs.next()) {
			 int id=rs.getInt(1);
			 String type=rs.getString(2);
			 int speed = rs.getInt(3);
			 Transport transport =new Transport(id,type,speed);
			 transports.add(transport);
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
		return transports;
	}

	@Override
	public Transport getEntityByType(String type) {
		Connection connection = conPool.retrieve();
		Transport transport = null;
		
		String query = "SELECT * FROM transport WHERE type=?";
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(query);
			
		ps.setString(1, type);
		
		 rs = ps.executeQuery();
		if(rs.next()) {
			int transportid = rs.getInt(1);
			String types = rs.getString(2);
			int speed = rs.getInt(3);
			
			transport = new Transport(transportid,types,speed);
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
		return transport;
	}

}
