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
	public void registrazione(UtenteRegistrato utente, String username, String password) throws DAOException {
		
		String sql = "insert into utente values(?,?,?,?,?,?,?)";
		String sql1="insert into acconut (?,?,?)";
		DataSource instance = DataSource.getInstance();
		
		Connection connection = instance.getConnection();
		PreparedStatement prepareStatement = null;
		PreparedStatement prepareStatement1 = null;
		
		try {
			prepareStatement=connection.prepareStatement(sql);			
			prepareStatement.setLong(1, utente.getID());
			prepareStatement.setString(2, utente.getNome());
			prepareStatement.setString(3, utente.getCognome());
			prepareStatement.setString(4, utente.getCodf());
			prepareStatement.setString(5, utente.getEmail());
			Date sqlDate = new Date(utente.getData().getTime());		
			prepareStatement.setDate(6, sqlDate);
			prepareStatement.setInt(7, utente.getFlagRuolo());
			prepareStatement.executeUpdate(sql);
			
			prepareStatement1 = connection.prepareStatement(sql1);
			
			prepareStatement1.setLong(1, utente.getID());
			prepareStatement1.setString(2, username);
			prepareStatement1.setString(3, password);
			prepareStatement.executeUpdate(sql1);

		} catch (SQLException e ) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			
		}
		
		
		
	}

	
}
