package it.ats.modello;

import java.util.Date;

public class Escursione {
	
	private Long id;
	private String luogo;
	private String tipo;
	private Date data;
	private int durata;
	private String difficolta;
	private double prezzo;
	private String guida;
	private int maxPartecipanti;
	private int numPrenotati=0;
	
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
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
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
	@Override
	public String toString() {
		
		String stampa="\n*****************************\n";
		return  stampa +"Escursione id=" + id + ":\nluogo=" + luogo + "\ntipo=" + tipo + "\ndata=" + data + "\ndurata=" + durata
				+ "\ndifficolta=" + difficolta + "\nprezzo=" + prezzo;
	}
	
	
	

}
