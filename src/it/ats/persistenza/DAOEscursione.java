package it.ats.persistenza;

import java.util.Collection;
import java.util.Map;

import it.ats.modello.Escursione;

public interface DAOEscursione {

	public void addEscursione(Escursione escursione) throws DAOException;

	public void updateEscursione(Escursione escursione) throws DAOException;

	public void deleteEscursione(Escursione escursione) throws DAOException;

	public Collection<Escursione> findAll() throws DAOException;

	public Collection<Escursione> findEscursioniDisponibili() throws DAOException;
	
	public Collection<Escursione> findEscursioniBySearch(String sql,Map<String,String> mapValori) throws DAOException;

	public Escursione findById(Long id) throws DAOException;

	public void deleteById(Long id) throws DAOException;

	public void bloccaEscursione(Long id) throws DAOException;
	
	public void sbloccaEscursione(Long id) throws DAOException;
	
	
	

}
