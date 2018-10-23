package it.ats.persistenza.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.ats.modello.Escursione;
import it.ats.persistenza.DAOEscursione;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DataSource;

public class DAOEscursioneImpl implements DAOEscursione {

	@Override
	public void addEscursione(Escursione escursione) throws DAOException {
		String sql = "insert into ESCURSIONI values(SEQ_ESCURSIONI.NEXTVAL,?,?,?,?,?,?,?,?,?)";

		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = instance.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, escursione.getLuogo());
			prepareStatement.setString(2, escursione.getTipo());
			Date sqlDate = new Date(escursione.getData().getTime());
			prepareStatement.setDate(3, sqlDate);
			prepareStatement.setInt(4, escursione.getDurata());
			prepareStatement.setString(5, escursione.getDifficolta());
			prepareStatement.setDouble(6, escursione.getPrezzo());
			prepareStatement.setString(7, escursione.getGuida());
			prepareStatement.setInt(8, escursione.getMaxPartecipanti());
			prepareStatement.setInt(9, escursione.getNumPrenotati());
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
	public void updateEscursione(Escursione escursione) throws DAOException {

		String sql = "update escursioni set luogo=?," + "tipo=?," + "data_escursione=?," + "durata=?," + "difficolta=?,"
				+ "prezzo=?," + "guida_escursione=?," + "max_partecipanti=?," + "num_prenotati=?" + "where id=?";

		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = instance.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, escursione.getLuogo());
			prepareStatement.setString(2, escursione.getTipo());
			Date sqlDate = new Date(escursione.getData().getTime());
			prepareStatement.setDate(3, sqlDate);
			prepareStatement.setInt(4, escursione.getDurata());
			prepareStatement.setString(5, escursione.getDifficolta());
			prepareStatement.setDouble(6, escursione.getPrezzo());
			prepareStatement.setString(7, escursione.getGuida());
			prepareStatement.setInt(8, escursione.getMaxPartecipanti());
			prepareStatement.setInt(9, escursione.getNumPrenotati());
			prepareStatement.setLong(10, escursione.getId());

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
	public void deleteEscursione(Escursione escursione) throws DAOException {
		String sql = "delete from ESCURSIONI where id= ?";

		System.out.println(sql);
		DataSource instance = DataSource.getInstance();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = instance.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, escursione.getId());
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
