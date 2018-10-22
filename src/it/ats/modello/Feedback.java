package it.ats.modello;

public class Feedback {
	
	private Long id;
	private Long id_escursione;
	private int voto;
	
	
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
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", id_escursione=" + id_escursione + ", voto=" + voto + "]";
	}

}
