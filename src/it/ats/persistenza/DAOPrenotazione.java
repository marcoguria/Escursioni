package it.ats.persistenza;

import java.util.Collection;

import it.ats.modello.Prenotazione;

public interface DAOPrenotazione {

	public void addPrenotazione(Prenotazione prenotazione) throws DAOException;

	public Collection<Prenotazione> findPrenotazioneByIdUtente(Long id_utente) throws DAOException;
	
	
	public void eliminaPrenotazione(Prenotazione prenotazione) throws DAOException;

}
