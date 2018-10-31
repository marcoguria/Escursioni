package it.ats.controllo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.ats.modello.Account;
import it.ats.modello.Cliente;
import it.ats.modello.Escursione;
import it.ats.modello.UtenteRegistrato;
import it.ats.persistenza.DAOAccount;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DataSource;
import it.ats.persistenza.impl.DAOAccountImpl;
import it.ats.persistenza.impl.DAOGuestImpl;
import it.ats.persistenza.impl.DAOUtenteRegistratoImpl;

public class TestMarco {

	public static void main(String[] args) {
		//testMetodi();
		
		testUpdate();
		
		
			

	}

	private static void testUpdate() {
		DAOUtenteRegistratoImpl daoUtenteRegistratoImpl = new DAOUtenteRegistratoImpl();
		try {
			UtenteRegistrato utenteRegistrato = daoUtenteRegistratoImpl.findUtenteById(4L);
			utenteRegistrato.setNome("MAX");
			daoUtenteRegistratoImpl.updateUtente(utenteRegistrato);
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void testMetodi() {
		DAOGuestImpl daoGuestImpl = new DAOGuestImpl();

		UtenteRegistrato cliente = new Cliente();
		cliente.setNome("GIGI");
		cliente.setCognome("SANNA");
		cliente.setData_nascita(new Date(1974, 5, 15));
		cliente.setCodf("GIGSNN98");
		cliente.setEmail("GIGI899@GMAIL.IT");
		cliente.setFlag_ruolo(1);
		cliente.setUsername("GIG78");
		cliente.setPassword("POMATA4");


		try {

			daoGuestImpl.registrazione(cliente);


		} catch (DAOException e) {
			System.out.println(e.getMessage());

		}

	}

}
