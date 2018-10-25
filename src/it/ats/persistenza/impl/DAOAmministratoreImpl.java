package it.ats.persistenza.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.ats.modello.Cliente;
import it.ats.modello.Escursione;
import it.ats.modello.UtenteRegistrato;
import it.ats.persistenza.DAOAmministratore;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DataSource;

public class DAOAmministratoreImpl implements DAOAmministratore {

	@Override
	public void aggiungiEscursione(Escursione escursione) throws DAOException {
		
		DAOEscursioneImpl daoEscursioneImpl= new DAOEscursioneImpl();
		daoEscursioneImpl.addEscursione(escursione);		
	}

	@Override
	public void modificaEscursione(Escursione escursione) throws DAOException {
		DAOEscursioneImpl daoEscursioneImpl= new DAOEscursioneImpl();
		daoEscursioneImpl.updateEscursione(escursione);

	}

	@Override
	public void eliminaEscursione(Escursione escursione) throws DAOException {
		DAOEscursioneImpl daoEscursioneImpl= new DAOEscursioneImpl();
		daoEscursioneImpl.deleteEscursione(escursione);
		
	}

	@Override
	public Collection<UtenteRegistrato> findAllUtenti() throws DAOException {

		Collection<UtenteRegistrato> utenti = new ArrayList<UtenteRegistrato>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM UTENTE");
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				UtenteRegistrato utenteRegistrato = new Cliente();

				utenteRegistrato.setID(resultSet.getLong("ID"));
				utenteRegistrato.setNome(resultSet.getString("NOME"));
				utenteRegistrato.setCognome(resultSet.getString("COGNOME"));
				utenteRegistrato.setCodf(resultSet.getString("CODF"));
				utenteRegistrato.setEmail(resultSet.getString("EMAIL"));
				utenteRegistrato.setData_nascita(resultSet.getDate("DATA_NASCITA"));
				utenteRegistrato.setFlag_ruolo(resultSet.getInt("FLAG_RUOLO"));
				utenti.add(utenteRegistrato);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException();
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}

		return utenti;

		}

	@Override
	public void eliminaUtente(UtenteRegistrato utente) throws DAOException {

		String sql = "delete from UTENTE where id= ?";

		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = instance.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, utente.getID());
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
