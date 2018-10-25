package it.ats.persistenza.impl;

import java.util.Collection;

import it.ats.modello.CartaPagamento;
import it.ats.modello.Cliente;
import it.ats.modello.Escursione;
import it.ats.modello.Prenotazione;
import it.ats.persistenza.DAOCliente;
import it.ats.persistenza.DAOException;

public class DAOClienteImpl implements DAOCliente {

	@Override
	public void prenotaEscursione(Escursione escursione, Cliente cliente) throws DAOException {

		DAOPrenotazioneImpl daoPrenotazioneImpl = new DAOPrenotazioneImpl();
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.getEscursione().getId();
		prenotazione.getUtenteRegistrato().getID();
		daoPrenotazioneImpl.addPrenotazione(prenotazione);

	}

	@Override
	public void aggiungiCarta(CartaPagamento carta) throws DAOException {
		DAOCartaPagamentoImpl cartaPagamentoImpl = new DAOCartaPagamentoImpl();
		cartaPagamentoImpl.aggiungiCartaPagamento(carta);
		

	}

	@Override
	public Collection<Prenotazione> visualizzaMiePrenotazioni(Long id_utente) throws DAOException {
		DAOPrenotazioneImpl daoPrenotazioneImpl = new DAOPrenotazioneImpl();
		return daoPrenotazioneImpl.findPrenotazioneByIdUtente(id_utente);
	}

	@Override
	public void eliminaCartaPagamento(CartaPagamento carta) throws DAOException {
		DAOCartaPagamentoImpl cartaPagamentoImpl = new DAOCartaPagamentoImpl();
		cartaPagamentoImpl.eliminaCartaPagamento(carta);

	}

}
