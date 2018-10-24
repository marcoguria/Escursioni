package it.ats.persistenza.impl;

import java.util.Collection;

import it.ats.modello.CartaPagamento;
import it.ats.modello.Cliente;
import it.ats.modello.Escursione;
import it.ats.modello.Prenotazione;
import it.ats.persistenza.DAOCliente;
import it.ats.persistenza.DAOException;

public class DAOClienteImpl implements DAOCliente{

	@Override
	public void prenotaEscursione(Escursione escursione, Cliente cliente) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aggiungiCarta(CartaPagamento carta) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Prenotazione> visualizzaMiePrenotazioni(Long id_utente) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminaCartaPagamento(Long id_utente) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}
