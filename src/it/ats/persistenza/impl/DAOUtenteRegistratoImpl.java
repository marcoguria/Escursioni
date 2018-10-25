package it.ats.persistenza.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.ats.modello.Amministratore;
import it.ats.modello.Cliente;
import it.ats.modello.UtenteRegistrato;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DAOUtenteRegistrato;
import it.ats.persistenza.DataSource;

public class DAOUtenteRegistratoImpl implements DAOUtenteRegistrato {

	@Override
	public UtenteRegistrato verificaAccount(String username, String password) throws DAOException {

		String sql = "SELECT * FROM UTENTE WHERE USERNAME= ? AND PASS = ?";
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

}
