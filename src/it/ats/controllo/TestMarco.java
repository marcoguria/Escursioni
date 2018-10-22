package it.ats.controllo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.ats.modello.Escursione;
import it.ats.persistenza.DAOException;
import it.ats.persistenza.DataSource;

public class TestMarco {

	public static void main(String[] args){
		 Escursione escursione= new Escursione();
		 escursione.setId(1L);
		 System.out.println(escursione);
			
	}

}
