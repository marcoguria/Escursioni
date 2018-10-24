package it.ats.persistenza;

import it.ats.modello.Account;

public interface DAOAccount {
	public void inserisciAccount(Account account) throws DAOException;
	public void eliminaAccount(Account account) throws DAOException;

}
