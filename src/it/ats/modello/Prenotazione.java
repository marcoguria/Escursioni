package it.ats.modello;

import java.util.Date;

public class Prenotazione {

	private Long id;
	private Long id_escursione;
	private Long id_utente;
	private Date data_prenotazione;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_escursione() {
		return id_escursione;
	}

	public void setId_escursione(Long id_escursione) {
		this.id_escursione = id_escursione;
	}

	public Long getId_utente() {
		return id_utente;
	}

	public void setId_utente(Long id_utente) {
		this.id_utente = id_utente;
	}

	public Date getDataPrenotazione() {
		return data_prenotazione;
	}

	public void setDataPrenotazione(Date data_prenotazione) {
		this.data_prenotazione = data_prenotazione;
	}

	@Override
	public String toString() {
		String stampa = "\n**********************\n";
		return stampa+ "Prenotazione: \nid=" + id + "\nid_escursione=" + id_escursione + "\nid_utente=" + id_utente
				+ "\ndata_prenotazione=" + data_prenotazione;
	}

}
