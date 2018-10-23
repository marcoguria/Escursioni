package it.ats.controllo;

import java.util.Date;

import it.ats.modello.Escursione;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.impl.DAOEscursioneImpl;

public class TestFrancesco {

	public static void main(String[] args) {

		addEscursione();

	}

	private static void addEscursione() {
		DAOEscursioneImpl daoEscursioneImpl = new DAOEscursioneImpl();
		Escursione escursione = new Escursione();
		escursione.setLuogo("SUPREMONTE");
		escursione.setTipo("MONTAGNA");
		escursione.setData(new Date(2018, 1, 5));
		escursione.setDurata(1);
		escursione.setDifficolta("ALTA");
		escursione.setPrezzo(15);
		escursione.setGuida("DIEGO");
		escursione.setMaxPartecipanti(15);
		
		try {
			daoEscursioneImpl.addEscursione(escursione);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}
}
