package ar.edu.unlam.dominio;

public class NoMoreVaccineException extends Exception {
	public NoMoreVaccineException() {
		super("Ya te aplicaste dos vacunas, no podes aplicarte más.");
	}
}
