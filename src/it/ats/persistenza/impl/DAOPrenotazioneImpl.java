package it.ats.persistenza.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.ats.modello.Prenotazione;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DAOPrenotazione;
import it.ats.persistenza.DataSource;

public class DAOPrenotazioneImpl implements DAOPrenotazione {

	@Override
	public void addPrenotazione(Prenotazione prenotazione) throws DAOException {
		String sql = "insert into PRENOTAZIONE values(SEQ_PRENOTAZIONE.NEXTVAL,?,?,?)";
		System.out.println(sql);
		
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

}
