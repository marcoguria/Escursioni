package it.ats.modello.persistenza;

public class DAOException extends Exception{
	private static final long serialVersionUID = 6700212922466694442L;

	public DAOException() {
		super();
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}
}
