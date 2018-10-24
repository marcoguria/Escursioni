package it.ats.persistenza;

import java.util.Collection;

import it.ats.modello.CartaPagamento;
import it.ats.modello.Cliente;
import it.ats.modello.Escursione;
import it.ats.modello.Prenotazione;

public interface DAOCliente {
	
	public void prenotaEscursione(Escursione escursione, Cliente cliente)throws DAOException ;
	public void aggiungiCarta(CartaPagamento carta) throws DAOException;
	public Collection<Prenotazione> visualizzaMiePrenotazioni(Long id_utente) throws DAOException;
	public void eliminaCartaPagamento(CartaPagamento carta) throws DAOException;

}
