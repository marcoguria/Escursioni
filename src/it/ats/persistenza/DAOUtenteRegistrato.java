package it.ats.persistenza;

import java.util.Collection;

import it.ats.modello.UtenteRegistrato;

public interface DAOUtenteRegistrato {
	
	public UtenteRegistrato verificaAccount(String username, String password) throws DAOException;
	public UtenteRegistrato findUtenteById(Long id) throws DAOException;
	public Collection<UtenteRegistrato> findAll() throws DAOException;
	public void updateUtente(UtenteRegistrato utenteRegistrato) throws DAOException;

}
