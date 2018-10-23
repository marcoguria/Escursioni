package it.ats.persistenza.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.ats.persistenza.DAOException;
import it.ats.persistenza.DAOUtenteRegistrato;
import it.ats.persistenza.DataSource;

public class DAOUtenteRegistratoImpl implements DAOUtenteRegistrato {

	@Override
	public boolean verificaAccount(String username, String password) throws DAOException {

		String sql = "SELECT ID_UTENTE FROM ACCOUNT WHERE USERNAME= ? AND PASSWORD = ?";
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
			
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}

		} catch (DAOException | SQLException e) {

			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		}

	}

	

}
