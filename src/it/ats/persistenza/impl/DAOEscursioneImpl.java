package it.ats.persistenza.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.ats.modello.Escursione;
import it.ats.persistenza.DAOEscursione;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DataSource;

public class DAOEscursioneImpl implements DAOEscursione {

	@Override
	public void addEscursione(Escursione escursione) throws DAOException {
		String sql = "insert into ESCURSIONE values(SEQ_ESCURSIONE.NEXTVAL,?,?,?,?,?,?,?,?,?)";

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

			}

			return escursione;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}

	}

	@Override
	public Collection<Escursione> findByLuogo(String luogo) throws DAOException {
		Collection<Escursione> escursioni = new ArrayList<Escursione>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM ESCURSIONE WHERE LUOGO=? ");
			statement.setString(1, luogo);
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
				escursioni.add(escursione);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException();
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}

		return escursioni;

	}

	@Override
	public Collection<Escursione> findByTipo(String tipo) throws DAOException {

		Collection<Escursione> escursioni = new ArrayList<Escursione>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM ESCURSIONE WHERE TIPO = ?");
			statement.setString(1, tipo);
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
	public Collection<Escursione> findByData(java.util.Date data) throws DAOException {
		Collection<Escursione> escursioni = new ArrayList<Escursione>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM ESCURSIONE WHERE DATA_ESCURSIONE = ?");
			Date sqlDate = new Date(data.getTime());
			statement.setDate(1, sqlDate);
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
				escursioni.add(escursione);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException();
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}

		return escursioni;

	}

	public Collection<Escursione> findByDurata(int durata) throws DAOException {
		Collection<Escursione> escursioni = new ArrayList<Escursione>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM ESCURSIONE WHERE DURATA = ?");
			statement.setDouble(1, durata);
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

	public Collection<Escursione> findByDifficolta(int difficolta)  throws DAOException{
		Collection<Escursione> escursioni = new ArrayList<Escursione>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM ESCURSIONE WHERE DIFFICOLTA = ?");
			statement.setInt(1, difficolta);
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

}
