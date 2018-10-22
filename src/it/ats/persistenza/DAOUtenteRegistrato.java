package it.ats.persistenza;



public interface DAOUtenteRegistrato {
	
	public boolean login(String username, String password) throws DAOException;
	public void logout()throws DAOException;

}
