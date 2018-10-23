package it.ats.persistenza;

import it.ats.modello.Escursione;

public interface DAOEscursione {
	
	public void addEscursione(Escursione escursione) throws DAOException;
	public void updateEscursione(Escursione escursione) throws DAOException;
	public void deleteEscursione(Escursione escursione) throws DAOException;
	 

}
