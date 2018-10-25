package it.ats.modello;

public class Feedback {
	
	private Long id;
	private Escursione escursione;
	private int voto;
	
	
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
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", escursione=" + escursione + ", voto=" + voto + "]";
	}
	
	

}
