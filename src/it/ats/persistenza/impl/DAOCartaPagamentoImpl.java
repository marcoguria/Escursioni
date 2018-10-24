package it.ats.persistenza.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.ats.modello.CartaPagamento;
import it.ats.persistenza.DAOCartaPagamento;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DataSource;

public class DAOCartaPagamentoImpl implements DAOCartaPagamento {

	@Override
	public void aggiungiCartaPagamento(CartaPagamento cartaPagamento) throws DAOException {
		String sql = "insert into CARTA_CREDITO values(SEQ_CARTA.NEXTVAL,?,?,?,?)";
		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = instance.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, cartaPagamento.getId_utente());
			prepareStatement.setString(2, cartaPagamento.getTipo());
			prepareStatement.setLong(3, cartaPagamento.getNumero_carta());
			prepareStatement.setLong(4, cartaPagamento.getCvv());
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
	public void eliminaCartaPagamento(CartaPagamento cartaPagamento) throws DAOException {
		String sql = "delete from CARTA_CREDITO where id= ?";
		System.out.println(sql);

		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = instance.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, cartaPagamento.getId());
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



















