package it.ats.persistenza;



public interface DAOUtenteRegistrato {
	
	public boolean verificaAccount(String username, String password) throws DAOException;


}
