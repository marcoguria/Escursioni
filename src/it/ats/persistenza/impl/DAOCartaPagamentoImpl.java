package it.ats.persistenza.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.ats.modello.Amministratore;
import it.ats.modello.CartaPagamento;
import it.ats.modello.Cliente;
import it.ats.modello.Escursione;
import it.ats.modello.UtenteRegistrato;
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
			prepareStatement.setLong(1, cartaPagamento.getUtente().getID());
			prepareStatement.setString(2, cartaPagamento.getTipo().toUpperCase());
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

	@Override
	public Collection<CartaPagamento> findCartePagamentoByIdUtente(Long id) throws DAOException {
		Collection<CartaPagamento> cartaPagamentos = new ArrayList<CartaPagamento>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement(
					"select * from carta_credito C inner join utente U on C.ID_UTENTE=U.ID \r\n" + "where U.ID=?");
			statement.setLong(1, id);

			resultSet = statement.executeQuery();

			if (resultSet == null)
				System.out.println("ResultSet nullo");
			else
				System.out.println("ho trovato qualcosa");

			while (resultSet.next()) {
				CartaPagamento cartaPagamento = new CartaPagamento();
				UtenteRegistrato utenteRegistrato = null;

				int flag_ruolo = resultSet.getInt("FLAG_RUOLO");

				System.out.println(flag_ruolo);

				if (flag_ruolo == 1) {
					utenteRegistrato = new Cliente();
				} else if (flag_ruolo == 0) {
					utenteRegistrato = new Amministratore();
				}

				utenteRegistrato.setID(resultSet.getLong("ID_UTENTE"));
				utenteRegistrato.setNome(resultSet.getString("NOME"));
				utenteRegistrato.setCognome(resultSet.getString("COGNOME"));
				utenteRegistrato.setCodf(resultSet.getString("CODF"));
				utenteRegistrato.setEmail(resultSet.getString("EMAIL"));
				utenteRegistrato.setData_nascita(resultSet.getDate("DATA_NASCITA"));
				utenteRegistrato.setFlag_ruolo(resultSet.getInt("FLAG_RUOLO"));
				utenteRegistrato.setUsername(resultSet.getString("USERNAME"));
				utenteRegistrato.setPassword(resultSet.getString("PASS"));

				cartaPagamento.setId(resultSet.getLong("ID"));
				cartaPagamento.setUtente(utenteRegistrato);
				cartaPagamento.setTipo(resultSet.getString("TIPO"));
				cartaPagamento.setNumero_carta(resultSet.getLong("NUMERO"));
				cartaPagamento.setCvv(resultSet.getLong("CVV"));

				cartaPagamentos.add(cartaPagamento);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}

		return cartaPagamentos;

	}

	@Override
	public CartaPagamento findCartePagamentoByIdCarta(Long id) throws DAOException {

		CartaPagamento cartaPagamento = new CartaPagamento();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement(
					"select * from carta_credito C inner join utente U on C.ID_UTENTE=U.ID \r\n" + "where C.ID=?");
			statement.setLong(1, id);

			resultSet = statement.executeQuery();
			if (resultSet == null)
				System.out.println("ResultSet nullo");
			else
				System.out.println("ho trovato qualcosa");

			while (resultSet.next()) {

				UtenteRegistrato utenteRegistrato = null;

				int flag_ruolo = resultSet.getInt("FLAG_RUOLO");

				System.out.println(flag_ruolo);

				if (flag_ruolo == 1) {
					utenteRegistrato = new Cliente();
				} else if (flag_ruolo == 0) {
					utenteRegistrato = new Amministratore();
				}

				utenteRegistrato.setID(resultSet.getLong("ID_UTENTE"));
				utenteRegistrato.setNome(resultSet.getString("NOME"));
				utenteRegistrato.setCognome(resultSet.getString("COGNOME"));
				utenteRegistrato.setCodf(resultSet.getString("CODF"));
				utenteRegistrato.setEmail(resultSet.getString("EMAIL"));
				utenteRegistrato.setData_nascita(resultSet.getDate("DATA_NASCITA"));
				utenteRegistrato.setFlag_ruolo(resultSet.getInt("FLAG_RUOLO"));
				utenteRegistrato.setUsername(resultSet.getString("USERNAME"));
				utenteRegistrato.setPassword(resultSet.getString("PASS"));

				cartaPagamento.setId(resultSet.getLong("ID"));
				cartaPagamento.setUtente(utenteRegistrato);
				cartaPagamento.setTipo(resultSet.getString("TIPO"));
				cartaPagamento.setNumero_carta(resultSet.getLong("NUMERO"));
				cartaPagamento.setCvv(resultSet.getLong("CVV"));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}

		return cartaPagamento;

	}

	@Override
	public CartaPagamento findCartePagamentoByNumeroCarta(Long numero_carta) throws DAOException {
		CartaPagamento cartaPagamento = new CartaPagamento();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement(
					"select * from carta_credito C inner join utente U on C.ID_UTENTE=U.ID \r\n" + "where C.NUMERO=?");
			statement.setLong(1, numero_carta);

			resultSet = statement.executeQuery();
//			if (resultSet == null)
//				System.out.println("ResultSet nullo");
//			else
//				System.out.println("ho trovato qualcosa");

			while (resultSet.next()) {

				UtenteRegistrato utenteRegistrato = null;

				int flag_ruolo = resultSet.getInt("FLAG_RUOLO");

				System.out.println(flag_ruolo);

				if (flag_ruolo == 1) {
					utenteRegistrato = new Cliente();
				} else if (flag_ruolo == 0) {
					utenteRegistrato = new Amministratore();
				}

				utenteRegistrato.setID(resultSet.getLong("ID_UTENTE"));
				utenteRegistrato.setNome(resultSet.getString("NOME"));
				utenteRegistrato.setCognome(resultSet.getString("COGNOME"));
				utenteRegistrato.setCodf(resultSet.getString("CODF"));
				utenteRegistrato.setEmail(resultSet.getString("EMAIL"));
				utenteRegistrato.setData_nascita(resultSet.getDate("DATA_NASCITA"));
				utenteRegistrato.setFlag_ruolo(resultSet.getInt("FLAG_RUOLO"));
				utenteRegistrato.setUsername(resultSet.getString("USERNAME"));
				utenteRegistrato.setPassword(resultSet.getString("PASS"));

				cartaPagamento.setId(resultSet.getLong("ID"));
				cartaPagamento.setUtente(utenteRegistrato);
				cartaPagamento.setTipo(resultSet.getString("TIPO"));
				cartaPagamento.setNumero_carta(resultSet.getLong("NUMERO"));
				cartaPagamento.setCvv(resultSet.getLong("CVV"));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}

		return cartaPagamento;

		
	}

}
