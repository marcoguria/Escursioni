package it.ats.persistenza;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import it.ats.modello.Escursione;
import it.ats.modello.Visitatore;

public interface DAOVisitatore {

	public Collection<Escursione> findAll() throws DAOException;

	public Collection<Escursione> cercaEscursioneByTipo(String tipo) throws DAOException;

	public Collection<Escursione> cercaEscursioneByData(Date data) throws DAOException;

	public Collection<Escursione> cercaEscursioneByLuogo(String luogo) throws DAOException;

	public Collection<Escursione> cercaEscursioneByDurata(int durata) throws DAOException;

	public Collection<Escursione> cercaEscursioneByDifficolta(int difficolta) throws DAOException;

	

}
