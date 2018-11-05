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
	private String username;
	private String password;
	private int attivo=1;


	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
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

	public Date getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}

	public int getFlag_ruolo() {
		return flag_ruolo;
	}

	public void setFlag_ruolo(int flag_ruolo) {
		this.flag_ruolo = flag_ruolo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public int getAttivo() {
		return attivo;
	}

	public void setAttivo(int attivo) {
		this.attivo = attivo;
	}

	

	@Override
	public String toString() {
		return "UtenteRegistrato [ID=" + ID + ", nome=" + nome + ", cognome=" + cognome + ", codf=" + codf + ", email="
				+ email + ", data_nascita=" + data_nascita + ", flag_ruolo=" + flag_ruolo + ", username=" + username
				+ ", password=" + password + ", attivo=" + attivo + "]";
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
