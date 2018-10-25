package it.ats.modello;

public class CartaPagamento {
	private Long id;
	private UtenteRegistrato utente;
	private String tipo;
	private Long numero_carta;
	private Long cvv;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UtenteRegistrato getUtente() {
		return utente;
	}

	public void setUtente(UtenteRegistrato utente) {
		this.utente = utente;
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
		return "CartaPagamento [id=" + id + ", utente=" + utente + ", tipo=" + tipo + ", numero_carta=" + numero_carta
				+ ", cvv=" + cvv + "]";
	}

}
