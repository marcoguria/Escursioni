package it.ats.modello;

import java.util.Date;

public abstract class UtenteRegistrato extends Visitatore {

	private int ID;
	private String nome;
	private String cognome;
	private String codf;
	private String email;
	private Date data;
	private int flagRuolo;

	public UtenteRegistrato() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getFlagRuolo() {
		return flagRuolo;
	}

	public void setFlagRuolo(int flagRuolo) {
		this.flagRuolo = flagRuolo;
	}

	@Override
	public String toString() {
		return "UtenteRegistrato [ID=" + ID + ", nome=" + nome + ", cognome=" + cognome + ", codf=" + codf + ", email="
				+ email + ", data=" + data + ", flagRuolo=" + flagRuolo + "]";
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
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (flagRuolo != other.flagRuolo)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
