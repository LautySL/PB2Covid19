package ar.edu.unlam.dominio;

public class NoCovidVaccineException extends Exception {
	public NoCovidVaccineException() {
		super("No se puede aplicar la segunda dosis, falta la primera.");
	}
}
