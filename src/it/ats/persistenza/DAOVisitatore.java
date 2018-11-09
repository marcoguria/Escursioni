package it.ats.persistenza;

import java.util.Collection;
import java.util.Map;

import it.ats.modello.Escursione;

public interface DAOVisitatore {

	public Collection<Escursione> findAll() throws DAOException;
	public Collection<Escursione> findBySearch(String sql,Map<String,String>  mapValori) throws DAOException;
	

}
