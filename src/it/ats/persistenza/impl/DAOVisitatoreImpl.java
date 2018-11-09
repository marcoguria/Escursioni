package it.ats.persistenza.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
	public Collection<Escursione> findBySearch(String sql, Map<String, String> mapValori) throws DAOException {
		DAOEscursioneImpl daoEscursioneImpl = new DAOEscursioneImpl();
		Collection<Escursione> escursioni = daoEscursioneImpl.findEscursioniBySearch(sql, mapValori);				
		return escursioni;
	}

	
}
