package it.ats.persistenza;

import it.ats.modello.CartaPagamento;

public interface DAOCartaPagamento {
	public void aggiungiCartaPagamento(CartaPagamento cartaPagamento) throws DAOException;
	public void eliminaCartaPagamento(CartaPagamento cartaPagamento) throws DAOException;

}
