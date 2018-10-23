package it.ats.modello;

import java.util.Date;

public abstract class UtenteRegistrato extends Visitatore {

	private Long ID;
	private String nome;
	private String cognome;
	private String codf;
	private String email;
	private Date data_nascita;
	private int flag_ruolo;
	

	public Long getID() {
		return ID;
	}



	public void setID(Long iD) {
		ID = iD;
	}



	public UtenteRegistrato() {

	}

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodf() {
		return codf;
	}

	public void setCodf(String codf) {
		this.codf = codf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascita() {
		return data_nascita;
	}

	public void setDataNascita(Date data) {
		this.data_nascita = data;
	}

	public int getFlagRuolo() {
		return flag_ruolo;
	}

	public void setFlagRuolo(int flagRuolo) {
		this.flag_ruolo = flagRuolo;
	}

	@Override
	public String toString() {
		return "UtenteRegistrato [ID=" + ID + ", nome=" + nome + ", cognome=" + cognome + ", codf=" + codf + ", email="
				+ email + ", data=" + data_nascita + ", flagRuolo=" + flag_ruolo + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtenteRegistrato other = (UtenteRegistrato) obj;
		if (ID != other.ID)
			return false;
		if (codf == null) {
			if (other.codf != null)
				return false;
		} else if (!codf.equals(other.codf))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (data_nascita == null) {
			if (other.data_nascita != null)
				return false;
		} else if (!data_nascita.equals(other.data_nascita))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (flag_ruolo != other.flag_ruolo)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
