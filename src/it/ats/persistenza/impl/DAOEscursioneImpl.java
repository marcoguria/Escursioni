package it.ats.persistenza.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;


import it.ats.modello.Escursione;
import it.ats.persistenza.DAOEscursione;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DataSource;

public class DAOEscursioneImpl implements DAOEscursione {

	@Override
	public void addEscursione(Escursione escursione) throws DAOException {
		String sql = "insert into ESCURSIONE values(SEQ_ESCURSIONE.NEXTVAL,?,?,?,?,?,?,?,?,?,'1')";

		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = instance.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, escursione.getLuogo());
			prepareStatement.setString(2, escursione.getTipo());
			Date sqlDate = new Date(escursione.getData().getTime());
			prepareStatement.setDate(3, sqlDate);
			prepareStatement.setDouble(4, escursione.getDurata());
			prepareStatement.setString(5, escursione.getDifficolta());
			prepareStatement.setDouble(6, escursione.getPrezzo());
			prepareStatement.setString(7, escursione.getGuida());
			prepareStatement.setInt(8, escursione.getMaxPartecipanti());
			prepareStatement.setInt(9, escursione.getNumPrenotati());

			System.out.println("inseriment nel database" + escursione);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			instance.close(prepareStatement);
			instance.close(connection);

		}

	}

	@Override
	public void updateEscursione(Escursione escursione) throws DAOException {

		String sql = "update ESCURSIONE set luogo=?," + "tipo=?," + "data_escursione=?," + "durata=?," + "difficolta=?,"
				+ "prezzo=?," + "guida_escursione=?," + "max_partecipanti=?," + "num_prenotati=?" + "where id=?";

		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = instance.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, escursione.getLuogo());
			prepareStatement.setString(2, escursione.getTipo());
			Date sqlDate = new Date(escursione.getData().getTime());
			prepareStatement.setDate(3, sqlDate);
			prepareStatement.setDouble(4, escursione.getDurata());
			prepareStatement.setString(5, escursione.getDifficolta());
			prepareStatement.setDouble(6, escursione.getPrezzo());
			prepareStatement.setString(7, escursione.getGuida());
			prepareStatement.setInt(8, escursione.getMaxPartecipanti());
			prepareStatement.setInt(9, escursione.getNumPrenotati());
			prepareStatement.setLong(10, escursione.getId());

			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			instance.close(prepareStatement);
			instance.close(connection);

		}

	}

	@Override
	public void deleteEscursione(Escursione escursione) throws DAOException {
		String sql = "delete from ESCURSIONE where id= ?";

		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = instance.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, escursione.getId());
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			instance.close(prepareStatement);
			instance.close(connection);

		}

	}

	@Override
	public Collection<Escursione> findAll() throws DAOException {
		Collection<Escursione> escursioni = new ArrayList<Escursione>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM ESCURSIONE");
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Escursione escursione = new Escursione();

				escursione.setId(resultSet.getLong("ID"));
				escursione.setLuogo(resultSet.getString("LUOGO"));
				escursione.setTipo(resultSet.getString("TIPO"));
				escursione.setData(resultSet.getDate("DATA_ESCURSIONE"));
				escursione.setDurata(resultSet.getDouble("DURATA"));
				escursione.setDifficolta(resultSet.getString("DIFFICOLTA"));
				escursione.setPrezzo(resultSet.getDouble("PREZZO"));
				escursione.setGuida(resultSet.getString("GUIDA_ESCURSIONE"));
				escursione.setMaxPartecipanti(resultSet.getInt("MAX_PARTECIPANTI"));
				escursione.setNumPrenotati(resultSet.getInt("NUM_PRENOTATI"));
				escursione.setDisponibile(resultSet.getInt("DISPONIBILE"));
				escursioni.add(escursione);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}

		return escursioni;

	}

	@Override
	public void deleteById(Long id) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("DELETE FROM ESCURSIONE WHERE ID = ?");
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}

	}

	@Override
	public Escursione findById(Long id) throws DAOException {
		Escursione escursione = new Escursione();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM ESCURSIONE WHERE ID = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				escursione.setId(resultSet.getLong("ID"));
				escursione.setLuogo(resultSet.getString("LUOGO"));
				escursione.setTipo(resultSet.getString("TIPO"));
				escursione.setData(resultSet.getDate("DATA_ESCURSIONE"));
				escursione.setDurata(resultSet.getDouble("DURATA"));
				escursione.setDifficolta(resultSet.getString("DIFFICOLTA"));
				escursione.setPrezzo(resultSet.getDouble("PREZZO"));
				escursione.setGuida(resultSet.getString("GUIDA_ESCURSIONE"));
				escursione.setMaxPartecipanti(resultSet.getInt("MAX_PARTECIPANTI"));
				escursione.setNumPrenotati(resultSet.getInt("NUM_PRENOTATI"));
				escursione.setDisponibile(resultSet.getInt("DISPONIBILE"));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}

		return escursione;

	}

	@Override
	public Collection<Escursione> findEscursioniDisponibili() throws DAOException {
		Collection<Escursione> escursioni = new ArrayList<Escursione>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement(
					"SELECT * FROM ESCURSIONE where NUM_PRENOTATI < MAX_PARTECIPANTI AND DISPONIBILE =1");
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Escursione escursione = new Escursione();

				escursione.setId(resultSet.getLong("ID"));
				escursione.setLuogo(resultSet.getString("LUOGO"));
				escursione.setTipo(resultSet.getString("TIPO"));
				escursione.setData(resultSet.getDate("DATA_ESCURSIONE"));
				escursione.setDurata(resultSet.getDouble("DURATA"));
				escursione.setDifficolta(resultSet.getString("DIFFICOLTA"));
				escursione.setPrezzo(resultSet.getDouble("PREZZO"));
				escursione.setGuida(resultSet.getString("GUIDA_ESCURSIONE"));
				escursione.setMaxPartecipanti(resultSet.getInt("MAX_PARTECIPANTI"));
				escursione.setNumPrenotati(resultSet.getInt("NUM_PRENOTATI"));
				escursione.setDisponibile(resultSet.getInt("DISPONIBILE"));
				escursioni.add(escursione);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}

		return escursioni;
	}

	@Override
	public void sbloccaEscursione(Long id) throws DAOException {
		String sql = "UPDATE ESCURSIONE SET DISPONIBILE = 1  WHERE ID=?";

		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = instance.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, id);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			instance.close(prepareStatement);
			instance.close(connection);

		}

	}

	@Override
	public void bloccaEscursione(Long id) throws DAOException {
		String sql = "UPDATE ESCURSIONE SET DISPONIBILE = 0  WHERE ID=?";

		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = instance.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, id);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			instance.close(prepareStatement);
			instance.close(connection);

		}

	}

	@Override
	public Collection<Escursione> findEscursioniBySearch(String sql, Map<String, String> mapValori)
			throws DAOException {

		System.out.println(sql);
		int index = 0;
		Collection<Escursione> escursioni = new ArrayList<Escursione>();

		DataSource instance = DataSource.getInstance();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;

		try {
			connection = instance.getConnection();
			prepareStatement = connection.prepareStatement(sql);

			if (mapValori.get("tipo") != null) {
				index++;
				prepareStatement.setString(index, mapValori.get("tipo"));

			}

			if (mapValori.get("dataEscursione") != null) {
				index++;
				
				java.util.Date date = new java.util.Date();
				 
				prepareStatement.setString(index, mapValori.get("dataEscursione")); // TODO controllare data escursione

			}

			if (mapValori.get("luogo") != null) {
				index++;
				prepareStatement.setString(index, mapValori.get("luogo"));

			}

			if (mapValori.get("durata") != null) {
				index++;
				prepareStatement.setString(index, mapValori.get("durata"));

			}

			if (mapValori.get("difficolta") != null) {
				index++;
				prepareStatement.setString(index, mapValori.get("difficolta"));

			}

			resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				Escursione escursione = new Escursione();

				escursione.setId(resultSet.getLong("ID"));
				escursione.setLuogo(resultSet.getString("LUOGO"));
				escursione.setTipo(resultSet.getString("TIPO"));
				escursione.setData(resultSet.getDate("DATA_ESCURSIONE"));
				escursione.setDurata(resultSet.getDouble("DURATA"));
				escursione.setDifficolta(resultSet.getString("DIFFICOLTA"));
				escursione.setPrezzo(resultSet.getDouble("PREZZO"));
				escursione.setGuida(resultSet.getString("GUIDA_ESCURSIONE"));
				escursione.setMaxPartecipanti(resultSet.getInt("MAX_PARTECIPANTI"));
				escursione.setNumPrenotati(resultSet.getInt("NUM_PRENOTATI"));
				escursione.setDisponibile(resultSet.getInt("DISPONIBILE"));
				escursioni.add(escursione);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			instance.close(prepareStatement);
			instance.close(connection);

		}

		return escursioni;
	}

}
