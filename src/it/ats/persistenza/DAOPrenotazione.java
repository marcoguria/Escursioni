package it.ats.persistenza;

import it.ats.modello.Prenotazione;

public interface DAOPrenotazione {

	
	public void addPrenotazione(Prenotazione prenotazione) throws DAOException;
}
