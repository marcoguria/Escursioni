package it.ats.persistenza.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.ats.modello.Amministratore;
import it.ats.modello.Cliente;
import it.ats.modello.Escursione;
import it.ats.modello.UtenteRegistrato;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DAOUtenteRegistrato;
import it.ats.persistenza.DataSource;

public class DAOUtenteRegistratoImpl implements DAOUtenteRegistrato {

	@Override
	public UtenteRegistrato verificaAccount(String username, String password) throws DAOException {

		String sql = "SELECT * FROM UTENTE WHERE USERNAME= ? AND PASS = ? AND ATTIVO=1";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		UtenteRegistrato utenteRegistrato = null;

		DataSource instance = DataSource.getInstance();
		try {
			connection = instance.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) { // 1=Cliente
				int flag_ruolo = resultSet.getInt("FLAG_RUOLO");

				System.out.println("\n\n\n\n");
				System.out.println(flag_ruolo);

				if (flag_ruolo == 1) {
					utenteRegistrato = new Cliente();
				} else if (flag_ruolo == 0) {
					utenteRegistrato = new Amministratore();
				}

				utenteRegistrato.setID(resultSet.getLong("ID"));
				utenteRegistrato.setNome(resultSet.getString("NOME"));
				utenteRegistrato.setCognome(resultSet.getString("COGNOME"));
				utenteRegistrato.setCodf(resultSet.getString("CODF"));
				utenteRegistrato.setEmail(resultSet.getString("EMAIL"));
				utenteRegistrato.setData_nascita(resultSet.getDate("DATA_NASCITA"));
				utenteRegistrato.setFlag_ruolo(resultSet.getInt("FLAG_RUOLO"));
				utenteRegistrato.setUsername(resultSet.getString("USERNAME"));
				utenteRegistrato.setPassword(resultSet.getString("PASS"));

			}

		} catch (DAOException | SQLException e) {

			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(preparedStatement);
			DataSource.getInstance().close(connection);

		}

		return utenteRegistrato;

	}

	@Override
	public UtenteRegistrato findUtenteById(Long id) throws DAOException {
		DataSource instance = DataSource.getInstance();

		Connection connection = instance.getConnection();
		PreparedStatement prepareStatement = null;
		UtenteRegistrato utenteRegistrato = null;
		ResultSet resultSet = null;

		try {
			prepareStatement = connection.prepareStatement("select * from UTENTE where id=?");
			prepareStatement.setLong(1, id);
			resultSet = prepareStatement.executeQuery();

			if (resultSet.next()) {

				int flag_ruolo = resultSet.getInt("FLAG_RUOLO");

				if (flag_ruolo == 1) {
					utenteRegistrato = new Cliente();
				} else {

					utenteRegistrato = new Amministratore();
				}

				utenteRegistrato.setID(resultSet.getLong("ID"));
				utenteRegistrato.setNome(resultSet.getString("NOME"));
				utenteRegistrato.setCognome(resultSet.getString("COGNOME"));
				utenteRegistrato.setCodf(resultSet.getString("CODF"));
				utenteRegistrato.setEmail(resultSet.getString("EMAIL"));
				utenteRegistrato.setData_nascita(resultSet.getDate("DATA_NASCITA"));
				utenteRegistrato.setFlag_ruolo(resultSet.getInt("FLAG_RUOLO"));
				utenteRegistrato.setUsername(resultSet.getString("USERNAME"));
				utenteRegistrato.setPassword(resultSet.getString("PASS"));
				utenteRegistrato.setAttivo(resultSet.getInt("ATTIVO"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			instance.close(resultSet);
			instance.close(prepareStatement);
			instance.close(connection);

		}

		return utenteRegistrato;
	}

	@Override
	public Collection<UtenteRegistrato> findAll() throws DAOException {
		Collection<UtenteRegistrato> utenti = new ArrayList<UtenteRegistrato>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		UtenteRegistrato utenteRegistrato = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM UTENTE");
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int flag_ruolo = resultSet.getInt("FLAG_RUOLO");

				if (flag_ruolo == 1) {
					utenteRegistrato = new Cliente();
				} else {

					utenteRegistrato = new Amministratore();
				}

				utenteRegistrato.setID(resultSet.getLong("ID"));
				utenteRegistrato.setNome(resultSet.getString("NOME"));
				utenteRegistrato.setCognome(resultSet.getString("COGNOME"));
				utenteRegistrato.setCodf(resultSet.getString("CODF"));
				utenteRegistrato.setEmail(resultSet.getString("EMAIL"));
				utenteRegistrato.setData_nascita(resultSet.getDate("DATA_NASCITA"));
				utenteRegistrato.setFlag_ruolo(resultSet.getInt("FLAG_RUOLO"));
				utenteRegistrato.setUsername(resultSet.getString("USERNAME"));
				utenteRegistrato.setPassword(resultSet.getString("PASS"));
				utenteRegistrato.setAttivo(resultSet.getInt("ATTIVO"));
				utenti.add(utenteRegistrato);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}

		return utenti;

	}

	@Override
	public void updateUtente(UtenteRegistrato utenteRegistrato) throws DAOException {
		String sql = "UPDATE utente SET nome = ?,cognome =?,codf=?,EMAIL=?,DATA_NASCITA=?,FLAG_RUOLO=?,USERNAME=?,PASS=? WHERE id =?";

		DataSource instance = DataSource.getInstance();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = instance.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, utenteRegistrato.getNome().toUpperCase());
			prepareStatement.setString(2, utenteRegistrato.getCognome().toUpperCase());
			prepareStatement.setString(3, utenteRegistrato.getCodf());
			prepareStatement.setString(4, utenteRegistrato.getEmail());
			Date sqlDate = new Date(utenteRegistrato.getData_nascita().getTime());
			prepareStatement.setDate(5, sqlDate);
			prepareStatement.setInt(6, utenteRegistrato.getFlag_ruolo());
			prepareStatement.setString(7, utenteRegistrato.getUsername());
			prepareStatement.setString(8, utenteRegistrato.getPassword());
			prepareStatement.setLong(9, utenteRegistrato.getID());
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
	public String findUsername(String username) throws DAOException {
		String sql = "select USERNAME from utente where USERNAME=?";
		DataSource instance = DataSource.getInstance();

		Connection connection = instance.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		String risultato=null;

		try {
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, username);
			resultSet = prepareStatement.executeQuery();

			if (resultSet.next()) {

			risultato=(resultSet.getString("USERNAME"));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			instance.close(resultSet);
			instance.close(prepareStatement);
			instance.close(connection);

		}

		return risultato;
	}

}
