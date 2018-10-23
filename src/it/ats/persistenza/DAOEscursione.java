package it.ats.persistenza;

import java.util.Collection;
import java.util.Date;

import it.ats.modello.Escursione;

public interface DAOEscursione {
	
	public void addEscursione(Escursione escursione) throws DAOException;
	public void updateEscursione(Escursione escursione) throws DAOException;
	public void deleteEscursione(Escursione escursione) throws DAOException;
	public Collection<Escursione> findAll() throws DAOException; 
	public Escursione findById(Long id) throws DAOException;
	public Collection<Escursione> findByLuogo(String luogo) throws DAOException;
	public Collection<Escursione> findByTipo(String tipo) throws DAOException;
	public Collection<Escursione> findByData(Date data) throws DAOException;
	public void deleteById(Long id)throws DAOException; 

}
