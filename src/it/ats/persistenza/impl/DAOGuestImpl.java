package it.ats.persistenza.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import it.ats.modello.UtenteRegistrato;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DAOGuest;
import it.ats.persistenza.DataSource;

public class DAOGuestImpl implements DAOGuest {

	@Override
	public void registrazione(UtenteRegistrato utente) throws DAOException {

		String sql = "insert into UTENTE values(SEQ_UTENTE.NEXTVAL,?,?,?,?,?,?,?,?,'1')";

		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = instance.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, utente.getNome());
			prepareStatement.setString(2, utente.getCognome());			
			prepareStatement.setString(3, utente.getCodf());
			prepareStatement.setString(4, utente.getEmail());
			Date sqlDate = new Date(utente.getData_nascita().getTime());
			prepareStatement.setDate(5, sqlDate);
			prepareStatement.setInt(6, utente.getFlag_ruolo());			
			prepareStatement.setString(7, utente.getUsername());
			prepareStatement.setString(8, utente.getPassword());
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
