package it.ats.modello;

import java.util.Date;

public class Prenotazione {

	private Long id;
	private Escursione escursione;
	private UtenteRegistrato utenteRegistrato;
	private Date data_prenotazione;

	@Override
	public String toString() {
		String stampa = "\n**********************\n";
		return stampa + "Prenotazione: \nid=" + id + "\nid_escursione=" + escursione.getId() + "\nid_utente="
				+ utenteRegistrato.getID() + "\ndata_prenotazione=" + data_prenotazione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Escursione getEscursione() {
		return escursione;
	}

	public void setEscursione(Escursione escursione) {
		this.escursione = escursione;
	}

	public Date getData_prenotazione() {
		return data_prenotazione;
	}

	public void setData_prenotazione(Date data_prenotazione) {
		this.data_prenotazione = data_prenotazione;
	}

	public UtenteRegistrato getUtenteRegistrato() {
		return utenteRegistrato;
	}

	public void setUtenteRegistrato(UtenteRegistrato utenteRegistrato) {
		this.utenteRegistrato = utenteRegistrato;
	}

}
