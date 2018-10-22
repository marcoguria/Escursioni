package it.ats.persistenza;

import java.util.Date;
import java.util.List;

public interface DAOVisitatore {
	
		List<Visitatore> findAll() throws DAOException;
		Visitatore findById(Long id)throws DAOException;
		void deleteById(Long id) throws DAOException;
		void update(Visitatore visitatore) throws DAOException;
		void save(Visitatore visitatore) throws DAOException;
		
		public List<Escursione> cercaEscursioneByTipo(String tipo) throws DAOException;
		public List<Escursione> cercaEscursioneByData(Date data) throws DAOException;
		public List<Escursione> cercaEscursioneByLuogo(String luogo) throws DAOException;
		public List<Escursione> cercaEscursioneByDurata(int durata) throws DAOException;
		public List<Escursione> cercaEscursioneByDifficolta(int difficolta) throws DAOException;
}
