package it.ats.modello;

public class CartaPagamento {
	private Long id;
	private Long id_utente;
	private String tipo;
	private Long numero_carta;
	private Long cvv;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_utente() {
		return id_utente;
	}
	public void setId_utente(Long id_utente) {
		this.id_utente = id_utente;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Long getNumero_carta() {
		return numero_carta;
	}
	public void setNumero_carta(Long numero_carta) {
		this.numero_carta = numero_carta;
	}
	public Long getCvv() {
		return cvv;
	}
	public void setCvv(Long cvv) {
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "CartaPagamento [id=" + id + ", id_utente=" + id_utente + ", tipo=" + tipo + ", numero_carta="
				+ numero_carta + ", cvv=" + cvv + "]";
	}

}
