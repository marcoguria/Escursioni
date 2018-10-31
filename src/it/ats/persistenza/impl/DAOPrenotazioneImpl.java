package it.ats.persistenza.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.ats.modello.Amministratore;
import it.ats.modello.Cliente;
import it.ats.modello.Escursione;
import it.ats.modello.Prenotazione;
import it.ats.modello.UtenteRegistrato;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DAOPrenotazione;
import it.ats.persistenza.DataSource;

public class DAOPrenotazioneImpl implements DAOPrenotazione {

	@Override
	public void addPrenotazione(Prenotazione prenotazione) throws DAOException {
		String sql = "insert into PRENOTAZIONE values(SEQ_PRENOTAZIONE.NEXTVAL,?,?,?)";
		System.out.println(sql);

		DataSource instance = DataSource.getInstance();
		Connection connection = null;
		PreparedStatement prepareStatement = null;

		try {
			connection = instance.getConnection();
			prepareStatement = connection.prepareStatement(sql, new String[] { "ID" });
			prepareStatement.setLong(1, prenotazione.getEscursione().getId());
			prepareStatement.setLong(2, prenotazione.getUtenteRegistrato().getID());
			Date sqlDate = new Date(prenotazione.getData_prenotazione().getTime());
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

	@Override
	public Collection<Prenotazione> findPrenotazioneByIdUtente(Long id_utente) throws DAOException {
		Collection<Prenotazione> prenotazioni = new ArrayList();
		

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		

		try {
			connection = DataSource.getInstance().getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM PRENOTAZIONE P INNER JOIN ESCURSIONE E ON "
					+ "P.ID_ESCURSIONE= E.ID "
					+ "INNER JOIN UTENTE U ON "
					+ "P.ID_UTENTE=U.ID "
					+ "WHERE P.ID_UTENTE=?");
			
			preparedStatement.setLong(1, id_utente);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Prenotazione prenotazione = new Prenotazione();
				Escursione escursione=new Escursione();
				UtenteRegistrato utenteRegistrato = null;
				
				int flag_ruolo = resultSet.getInt("FLAG_RUOLO");			
				if (flag_ruolo == 1) {
					utenteRegistrato  = new Cliente();
				} else if (flag_ruolo == 0) {
					utenteRegistrato = new Amministratore();
				}			
				
				escursione.setId(resultSet.getLong("ID_ESCURSIONE"));
				escursione.setLuogo(resultSet.getString("LUOGO"));
				escursione.setTipo(resultSet.getString("TIPO"));
				escursione.setData(resultSet.getDate("DATA_ESCURSIONE"));
				escursione.setDurata(resultSet.getDouble("DURATA"));
				escursione.setDifficolta(resultSet.getString("DIFFICOLTA"));
				escursione.setPrezzo(resultSet.getDouble("PREZZO"));
				escursione.setGuida(resultSet.getString("GUIDA_ESCURSIONE"));
				escursione.setMaxPartecipanti(resultSet.getInt("MAX_PARTECIPANTI"));
				escursione.setNumPrenotati(resultSet.getInt("NUM_PRENOTATI"));
				
				utenteRegistrato.setID(resultSet.getLong("ID_UTENTE"));
				utenteRegistrato.setNome(resultSet.getString("NOME"));
				utenteRegistrato.setCognome(resultSet.getString("COGNOME"));
				utenteRegistrato.setCodf(resultSet.getString("CODF"));
				utenteRegistrato.setEmail(resultSet.getString("EMAIL"));
				utenteRegistrato.setData_nascita(resultSet.getDate("DATA_NASCITA"));
				utenteRegistrato.setFlag_ruolo(resultSet.getInt("FLAG_RUOLO"));
				
				
				prenotazione.setId(resultSet.getLong("ID"));
				prenotazione.setEscursione(escursione);
				prenotazione.setUtenteRegistrato(utenteRegistrato);
				prenotazione.setData_prenotazione(resultSet.getDate("DATA_PRENOTAZIONE"));
				System.out.println(prenotazione);
				prenotazioni.add(prenotazione);
				
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(preparedStatement);
			DataSource.getInstance().close(connection);
		}
		return prenotazioni;
	}

	@Override
	public void eliminaPrenotazione(Prenotazione prenotazione) throws DAOException {
		String sql = "delete from PRENOTAZIONE where id= ?";
		System.out.println(sql);

		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = instance.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, prenotazione.getId());
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
