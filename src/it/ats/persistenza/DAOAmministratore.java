package it.ats.persistenza;

import it.ats.modello.Escursione;

public interface DAOAmministratore {
	
	public void aggiungiEscursione(Escursione escursione) throws DAOException;
	public void modificaEscursione(Escursione escursione) throws DAOException;
	public void eliminaEscursione(Escursione escursione) throws DAOException;
	
	
	
}
