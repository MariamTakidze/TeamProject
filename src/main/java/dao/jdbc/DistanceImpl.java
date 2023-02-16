package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IDistance;
import models.Distance;
import utils.ConnectionPool;

public class DistanceImpl implements IDistance {

	private static final Logger LOGGER = LogManager.getLogger(CityImpl.class);

	ConnectionPool conPool = ConnectionPool.getinstance();

	@Override
	public void updateEntityById(int id, int id2,Distance distance) {
		Connection connection = conPool.retrieve();
		
		String query = "UPDATE  distances SET  distance=? WHERE station_id_1=? and station_id_2=?";
		PreparedStatement ps = null;
		
		

		try {
			ps=connection.prepareStatement(query);
			ps.setInt(1, distance.getDistance());
			ps.setInt(2, id);
			ps.setInt(3, id2);


			

			ps.execute();
			LOGGER.info("distances successfully updated");

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
	public void insertEntity(Distance t) {
		Connection connection = conPool.retrieve();

		String query = "INSERT INTO distances VALUES(?,?,?)";
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, t.getIdStation1());
			ps.setInt(2, t.getIdStation2());
			ps.setInt(3, t.getDistance());

			ps.execute();
			LOGGER.info("distance successfully inserted");

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
					LOGGER.info("PreparedStatement closed succesfully");

				} catch (SQLException e) {
					LOGGER.error(e);
				}
			}
			if (connection != null) {
				conPool.putback(connection);
				LOGGER.info("Connection putback is successfull");
			}
		}
	}

	@Override
	public List<Distance> getALLEntities() {
		Connection connection = conPool.retrieve();
		List<Distance> distances = new ArrayList<>();
		
		String query = "SELECT * FROM distances ";
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(query);

		 rs =  ps.executeQuery();
		 while(rs.next()) {
			 int id=rs.getInt(1);
			 int id2=rs.getInt(2);
			 int dist=rs.getInt(3);
			 
			 Distance distance =new Distance(id,id2,dist);
			 distances.add(distance);
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
		return distances;
	}

	@Override
	public Distance readEntityByIds(int id, int id2) {
		Connection connection = conPool.retrieve();
		Distance distance = null;

		String query = "SELECT * FROM distances WHERE station_id_1=? and station_id_2=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(query);

			ps.setInt(1, id);
			ps.setInt(2, id2);

			rs = ps.executeQuery();
			if (rs.next()) {
				int dist1 = rs.getInt(1);
				int dist2 = rs.getInt(2);
				int speed = rs.getInt(3);

				distance = new Distance(dist1, dist2, speed);
			}

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			if (rs != null)
				try {
					rs.close();
					LOGGER.info("ResultSet closed succesfully");
				} catch (SQLException e) {
					LOGGER.error(e);
				}
			if (ps != null) {
				try {
					ps.close();
					LOGGER.info("PreparedStarement closed succesfully");
				} catch (SQLException e) {
					LOGGER.error(e);
				}
			}

			if (connection != null) {
				conPool.putback(connection);
				LOGGER.info("Connection putback is successfull");
			}
		}
		return distance;
	}

	@Override
	public void deleteEntityByIds(int id, int id2) {
		Connection connection = conPool.retrieve();
		String query = "DELETE FROM distances WHERE station_id_1=? and station_id_2=?";
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.setInt(2, id2);

			ps.execute();
			LOGGER.info("distance successfully deleted");

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
					LOGGER.info("PreparedStatement closed succesfully");

				} catch (SQLException e) {
					LOGGER.error(e);
				}
			}
			if (connection != null) {
				conPool.putback(connection);
				LOGGER.info("Connection putback is successfull");
			}
		}

	}

}
