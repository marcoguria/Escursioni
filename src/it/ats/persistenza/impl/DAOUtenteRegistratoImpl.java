package it.ats.persistenza.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.ats.modello.UtenteRegistrato;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DAOUtenteRegistrato;
import it.ats.persistenza.DataSource;

public class DAOUtenteRegistratoImpl implements DAOUtenteRegistrato {

	@Override
	public UtenteRegistrato verificaAccount(String username, String password) throws DAOException {

		String sql = "SELECT * FROM UTENTE WHERE USERNAME= ? AND PASSWORD = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		DataSource instance = DataSource.getInstance();
		try {
			connection = instance.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			resultSet = preparedStatement.executeQuery();
			
			UtenteRegistrato utenteRegistrato = null; 
			
			if(utenteRegistrato.getFlag_ruolo()==1)              //1=Cliente
				
				
			
			while (resultSet.next()) {
			
			
				
				
				
				utenteRegistrato.setID(resultSet.getLong("ID"));
				
			}		

		} catch (DAOException | SQLException e) {

			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		}

	}

}
