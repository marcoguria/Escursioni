package it.ats.modello;

import java.util.Date;

public class Escursione {
	
	private Long id;
	private String luogo;
	private String tipo;
	private Date data;
	private double durata;
	private String difficolta;
	private double prezzo;
	private String guida;
	private int maxPartecipanti;
	private int numPrenotati=0;
	private int disponibile=1; //di default l'escursione è disponibile
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public double getDurata() {
		return durata;
	}
	public void setDurata(double durata) {
		this.durata = durata;
	}
	public String getDifficolta() {
		return difficolta;
	}
	public void setDifficolta(String difficolta) {
		this.difficolta = difficolta;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getGuida() {
		return guida;
	}
	public void setGuida(String guida) {
		this.guida = guida;
	}
	public int getMaxPartecipanti() {
		return maxPartecipanti;
	}
	public void setMaxPartecipanti(int maxPartecipanti) {
		this.maxPartecipanti = maxPartecipanti;
	}
	public int getNumPrenotati() {
		return numPrenotati;
	}
	public void setNumPrenotati(int numPrenotati) {
		this.numPrenotati = numPrenotati;
	}
	public int getDisponibile() {
		return disponibile;
	}
	public void setDisponibile(int disponibile) {
		this.disponibile = disponibile;
	}
	@Override
	public String toString() {
		return "Escursione [id=" + id + ", luogo=" + luogo + ", tipo=" + tipo + ", data=" + data + ", durata=" + durata
				+ ", difficolta=" + difficolta + ", prezzo=" + prezzo + ", guida=" + guida + ", maxPartecipanti="
				+ maxPartecipanti + ", numPrenotati=" + numPrenotati + ", disponibile=" + disponibile + "]";
	}
	
	
	
	

}
