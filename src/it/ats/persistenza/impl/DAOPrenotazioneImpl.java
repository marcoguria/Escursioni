package it.ats.persistenza.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.ats.modello.Escursione;
import it.ats.modello.Prenotazione;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DAOPrenotazione;
import it.ats.persistenza.DataSource;

public class DAOPrenotazioneImpl implements DAOPrenotazione {

	@Override
	public void addPrenotazione(Prenotazione prenotazione) throws DAOException {
		String sql = "insert into PRENOTAZIONE values(SEQ_PRENOTAZIONE.NEXTVAL,?,?,?)";
		System.out.println(sql);

		DataSource instance = DataSource.getInstance();
		Connection connection = null;
		PreparedStatement prepareStatement = null;

		try {
			connection = instance.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, prenotazione.getId_escursione());
			prepareStatement.setLong(2, prenotazione.getId_utente());
			Date sqlDate = new Date(prenotazione.getDataPrenotazione().getTime());
			prepareStatement.setDate(3, sqlDate);
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
	public Collection<Prenotazione> findPrenotazioneByIdUtente(Long id_utente) throws DAOException {
		Collection<Prenotazione> prenotazioni = new ArrayList();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM PRENOTAZIONE WHERE ID_UTENTE = ?");
			statement.setLong(1, id_utente);
			resultSet = statement.executeQuery();

			while(resultSet.next()) {
				Prenotazione prenotazione = new Prenotazione();
				prenotazione.setId(resultSet.getLong("ID"));
				prenotazione.setId_escursione(resultSet.getLong("ID_ESCURSIONE"));
				prenotazione.setId_utente(resultSet.getLong("ID_UTENTE"));
				prenotazione.setDataPrenotazione(resultSet.getDate("DATA_PRENOTAZIONE"));
				prenotazioni.add(prenotazione);
			}
		

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return prenotazioni;
	}

	@Override
	public void eliminaPrenotazione(Prenotazione prenotazione) throws DAOException {
		String sql = "delete from PRENOTAZIONE where id= ?";
		System.out.println(sql);

		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = instance.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, prenotazione.getId());
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			instance.close(prepareStatement);
			instance.close(connection);

		}

	}

}
