package it.ats.persistenza;

import java.util.Collection;

import it.ats.modello.CartaPagamento;

public interface DAOCartaPagamento {
	public void aggiungiCartaPagamento(CartaPagamento cartaPagamento) throws DAOException;
	public void eliminaCartaPagamento(CartaPagamento cartaPagamento) throws DAOException;
	public Collection<CartaPagamento> findCartePagamentoByIdUtente(Long id) throws DAOException;
	public CartaPagamento findCartePagamentoByIdCarta(Long id) throws DAOException;
	
	

}
