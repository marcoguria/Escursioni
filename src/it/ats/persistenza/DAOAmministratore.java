package it.ats.persistenza;

import java.util.Collection;

import it.ats.modello.Escursione;
import it.ats.modello.UtenteRegistrato;

public interface DAOAmministratore {
	
	public void aggiungiEscursione(Escursione escursione) throws DAOException;
	public void modificaEscursione(Escursione escursione) throws DAOException;
	public void eliminaEscursione(Escursione escursione) throws DAOException;
	public Collection<UtenteRegistrato> findAllUtenti () throws DAOException;
	public void eliminaUtente(UtenteRegistrato utente) throws DAOException;
}
