package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IStation;
import models.Station;
import utils.ConnectionPool;

public class StationImpl implements IStation {

	private static final Logger LOGGER = LogManager.getLogger(StationImpl.class);

	ConnectionPool conPool = ConnectionPool.getinstance();

	@Override
	public Station readEntityById(int id) {
		Connection connection = conPool.retrieve();
		Station station = null;

		String query = "SELECT * FROM stations WHERE id_stations=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(query);

			ps.setInt(1, id);

			rs = ps.executeQuery();
			if (rs.next()) {
				int statid = rs.getInt(1);
				String name = rs.getString(2);
				int cityid = rs.getInt(3);

				station = new Station(statid, name, cityid);
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
		return station;
	}

	@Override
	public void updateEntityById(int id, Station station) {
		Connection connection = conPool.retrieve();

		String query = "UPDATE  stations SET  name=?, city_id=? WHERE id_stations=?";
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, station.getName());
			ps.setInt(2, station.getIdCity());
			ps.setInt(3, id);

			ps.execute();
			LOGGER.info("city successfully updated");

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
	public void insertEntity(Station t) {
		Connection connection = conPool.retrieve();

		String query = "INSERT INTO stations VALUES(?,?,?)";
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, t.getIdStation());
			ps.setString(2, t.getName());
			ps.setInt(3, t.getIdCity());

			ps.execute();
			LOGGER.info("station successfully inserted");

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
	public void deleteEntityById(int id) {
		Connection connection = conPool.retrieve();
		String query = "DELETE FROM stations WHERE id_stations=?";
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(query);
			ps.setLong(1, id);

			ps.execute();
			LOGGER.info("station successfully deleted");

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
	public List<Station> getALLEntities() {
		Connection connection = conPool.retrieve();
		List<Station> stations = new ArrayList<>();

		String query = "SELECT * FROM stations ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(query);

			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int cityId = rs.getInt(3);

				Station stat = new Station(id, name, cityId);
				stations.add(stat);
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
		return stations;
	}

	@Override
	public Station getEntityByName(String name) {
		Connection connection = conPool.retrieve();
		Station station = null;

		String query = "SELECT * FROM stations WHERE name=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(query);

			ps.setString(1, name);

			rs = ps.executeQuery();
			if (rs.next()) {
				int statid = rs.getInt(1);
				String namest = rs.getString(2);
				int cityid = rs.getInt(3);

				station = new Station(statid, namest, cityid);
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
		return station;
	}

}
