package it.ats.persistenza.impl;

import it.ats.modello.Escursione;
import it.ats.persistenza.DAOAmministratore;
import it.ats.persistenza.DAOException;

public class DAOAmministratoreImpl implements DAOAmministratore {

	@Override
	public void aggiungiEscursione(Escursione escursione) throws DAOException {
		
		DAOEscursioneImpl daoEscursioneImpl= new DAOEscursioneImpl();
		daoEscursioneImpl.addEscursione(escursione);		
	}

	@Override
	public void modificaEscursione(Escursione escursione) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminaEscursione(Escursione escursione) throws DAOException {
		// TODO Auto-generated method stub

	}

}
