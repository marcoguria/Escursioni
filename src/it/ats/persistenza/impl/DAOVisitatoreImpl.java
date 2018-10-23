package it.ats.persistenza.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import it.ats.modello.Escursione;
import it.ats.modello.Visitatore;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DAOVisitatore;

public class DAOVisitatoreImpl implements DAOVisitatore {

	@Override
	public Collection<Escursione> findAll() throws DAOException {
		DAOEscursioneImpl daoEscursioneImpl = new DAOEscursioneImpl();
		Collection<Escursione> escursioni = daoEscursioneImpl.findAll();
		return escursioni;
	}

	@Override
	public Collection<Escursione> cercaEscursioneByTipo(String tipo) throws DAOException {
		DAOEscursioneImpl daoEscursioneImpl = new DAOEscursioneImpl();
		Collection<Escursione> escursioni = daoEscursioneImpl.findByTipo(tipo);
		return escursioni;
	}

	@Override
	public Collection<Escursione> cercaEscursioneByData(Date data) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Escursione> cercaEscursioneByLuogo(String luogo) throws DAOException {
		DAOEscursioneImpl daoEscursioneImpl = new DAOEscursioneImpl();
		Collection<Escursione> escursioni = daoEscursioneImpl.findByLuogo(luogo);				
		return escursioni;
	}

	@Override
	public Collection<Escursione> cercaEscursioneByDurata(int durata) throws DAOException {
		DAOEscursioneImpl daoEscursioneImpl = new DAOEscursioneImpl();
		Collection<Escursione> escursioni = daoEscursioneImpl.findByDurata(durata);				
		return escursioni;
	}

	@Override
	public Collection<Escursione> cercaEscursioneByDifficolta(int difficolta) throws DAOException {
		DAOEscursioneImpl daoEscursioneImpl = new DAOEscursioneImpl();
		Collection<Escursione> escursioni = daoEscursioneImpl.findByDifficolta(difficolta);				
		return escursioni;
	}

	

}
