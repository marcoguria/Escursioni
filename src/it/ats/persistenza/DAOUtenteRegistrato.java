package it.ats.persistenza;

import it.ats.modello.UtenteRegistrato;

public interface DAOUtenteRegistrato {
	
	public UtenteRegistrato verificaAccount(String username, String password) throws DAOException;


}
