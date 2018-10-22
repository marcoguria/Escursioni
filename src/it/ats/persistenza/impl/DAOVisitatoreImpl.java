package it.ats.persistenza.impl;

import java.util.Date;
import java.util.List;

import it.ats.modello.Escursione;
import it.ats.modello.Visitatore;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DAOVisitatore;

public class DAOVisitatoreImpl implements DAOVisitatore{

	@Override
	public List<Visitatore> findAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Visitatore findById(Long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Visitatore visitatore) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Visitatore visitatore) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Escursione> cercaEscursioneByTipo(String tipo) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Escursione> cercaEscursioneByData(Date data) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Escursione> cercaEscursioneByLuogo(String luogo) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Escursione> cercaEscursioneByDurata(int durata) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Escursione> cercaEscursioneByDifficolta(int difficolta) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
