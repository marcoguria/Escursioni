package it.ats.controllo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import it.ats.modello.Escursione;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.impl.DAOEscursioneImpl;

public class TestFrancesco {

	public static void main(String[] args) {

		// addEscursione();
		// updateEscursione();
		findByTipo();

	}

	private static void findByTipo() {
		DAOEscursioneImpl daoEscursioneImpl = new DAOEscursioneImpl();

		try {
			Collection<Escursione> escursioni = daoEscursioneImpl.findByTipo("MARE");
			Iterator<Escursione> iterator = escursioni.iterator();
			
			while(iterator.hasNext()) {
				System.out.println();
				
			}
			
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void updateEscursione() {
		DAOEscursioneImpl daoEscursioneImpl = new DAOEscursioneImpl();
		Escursione escursione = new Escursione();
		escursione.setId(41L);
		escursione.setLuogo("SUPREMONTE");
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
