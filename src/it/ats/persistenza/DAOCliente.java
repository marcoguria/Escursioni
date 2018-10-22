package it.ats.persistenza;

import it.ats.modello.Cliente;
import it.ats.modello.Escursione;

public interface DAOCliente {
	
	public void prenotaEscursione(Escursione escursione, Cliente cliente)throws DAOException ;

}
