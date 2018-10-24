package it.ats.persistenza;

import it.ats.modello.UtenteRegistrato;

public interface DAOGuest {
	
	/**
	 * Questo metodo permette a un utente non registrati, di registrarsi sulla piattaforma
	 * @param utente: contiene tutti i parametri di registrazione del nuovo utente
	 * @param username: lo username inserito dall utente
	 * @param password: la password nuova 
	 * @throws DAOException
	 */
	public void registrazione (UtenteRegistrato utente) throws DAOException;
		
}
