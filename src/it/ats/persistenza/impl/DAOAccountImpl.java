package it.ats.persistenza.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.ats.modello.Account;
import it.ats.persistenza.DAOAccount;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DataSource;

public class DAOAccountImpl implements DAOAccount {

	@Override
	public void inserisciAccount(Account account) throws DAOException {
		
		String sql = "insert into ACCOUNT values(?,?,?)";
		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = instance.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, account.getId());
			prepareStatement.setString(2, account.getUsername());
			prepareStatement.setString(3, account.getPassword());			
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
	public void eliminaAccount(Account account) throws DAOException {
		String sql = "delete from ACCOUNT where id= ?";
		System.out.println(sql);

		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = instance.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, account.getId());
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
