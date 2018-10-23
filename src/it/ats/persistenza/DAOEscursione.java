package it.ats.persistenza;

import it.ats.modello.Escursione;

public interface DAOEscursione {
	
	public void addEscursione(Escursione escursione) throws DAOException;

}
