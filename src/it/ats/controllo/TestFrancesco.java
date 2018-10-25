package it.ats.controllo;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import it.ats.modello.Cliente;
import it.ats.modello.Escursione;
import it.ats.modello.Prenotazione;
import it.ats.modello.UtenteRegistrato;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DAOUtenteRegistrato;
import it.ats.persistenza.impl.DAOEscursioneImpl;
import it.ats.persistenza.impl.DAOPrenotazioneImpl;
import it.ats.persistenza.impl.DAOUtenteRegistratoImpl;

public class TestFrancesco {

	public static void main(String[] args) {

		// addEscursione();//CORRETTO
		// updateEscursione();//CORRETTO
//		System.out.println("sto ESEGUENDO LA BY tipo\n\n\n\n");
//		findByTipo(); // TODO DA CORREGGERE
//		// findByID();//CORRETTA
//		System.out.println("sto ESEGUENDO LA BY LUOGO\n\n\n\n");
//		findByLuogo();
//		// deleteEscursione();// CORRETTO
//		System.out.println("sto ESEGUENDO LA BYALL tipo\n\n\n\n");
//		findAll();

		//addPrenotazione();
		verificaAccount();
		
		

	}

	private static void verificaAccount() {
		UtenteRegistrato utenteRegistrato= null;
		DAOUtenteRegistrato daoUtenteRegistrato = new DAOUtenteRegistratoImpl();
		
		try {
			utenteRegistrato = daoUtenteRegistrato.verificaAccount("admin", "admin");
			System.out.println(utenteRegistrato);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void addPrenotazione() {
		DAOPrenotazioneImpl daoPrenotazione = new DAOPrenotazioneImpl();

		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setDataPrenotazione(new Date(2019,5, 8));
		prenotazione.setId_escursione(26L);
		prenotazione.setId_utente(2L);
		try {
			daoPrenotazione.addPrenotazione(prenotazione);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void findAll() {
		DAOEscursioneImpl daoEscursioneImpl = new DAOEscursioneImpl();
		Collection<Escursione> escursioni = null;

		try {

			escursioni = daoEscursioneImpl.findAll();
			for (Iterator iterator = escursioni.iterator(); iterator.hasNext();) {
				Escursione escursione = (Escursione) iterator.next();
				System.out.println(escursione);

			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void deleteEscursione() {
		DAOEscursioneImpl daoEscursioneImpl = new DAOEscursioneImpl();

		try {
			daoEscursioneImpl.deleteById(13L);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void findByLuogo() {
		DAOEscursioneImpl daoEscursioneImpl = new DAOEscursioneImpl();
		Collection<Escursione> escursioni = null;

		try {

			escursioni = daoEscursioneImpl.findByLuogo("GORROPPU");
			for (Iterator iterator = escursioni.iterator(); iterator.hasNext();) {
				Escursione escursione = (Escursione) iterator.next();
				System.out.println(escursione);

			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void findByID() {
		DAOEscursioneImpl daoEscursioneImpl = new DAOEscursioneImpl();
		try {
			Escursione escursione = daoEscursioneImpl.findById(22L);
			System.out.println(escursione);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void findByTipo() {
		DAOEscursioneImpl daoEscursioneImpl = new DAOEscursioneImpl();
		Collection<Escursione> escursioni = null;

		try {

			escursioni = daoEscursioneImpl.findByLuogo("MARE");
			for (Iterator iterator = escursioni.iterator(); iterator.hasNext();) {
				Escursione escursione = (Escursione) iterator.next();
				System.out.println(escursione);

			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void updateEscursione() {
		DAOEscursioneImpl daoEscursioneImpl = new DAOEscursioneImpl();
		Escursione escursione = new Escursione();
		escursione.setId(41L);
		escursione.setLuogo("SUPRAMONTE");
		escursione.setTipo("MONTAGNA");
		escursione.setData(new Date(2018, 1, 5));
		escursione.setDurata(1);
		escursione.setDifficolta("ALTA");
		escursione.setPrezzo(15);
		escursione.setGuida("DIEGO");
		escursione.setMaxPartecipanti(20);

		try {
			daoEscursioneImpl.updateEscursione(escursione);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void addEscursione() {
		DAOEscursioneImpl daoEscursioneImpl = new DAOEscursioneImpl();
		Escursione escursione = new Escursione();
		escursione.setLuogo("ASINARA");
		escursione.setTipo("MARE");
		escursione.setData(new Date(2018, 1, 5));
		escursione.setDurata(1);
		escursione.setDifficolta("BASSA");
		escursione.setPrezzo(15);
		escursione.setGuida("GIUSEPPE");
		escursione.setMaxPartecipanti(15);

		try {
			daoEscursioneImpl.addEscursione(escursione);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}
}
