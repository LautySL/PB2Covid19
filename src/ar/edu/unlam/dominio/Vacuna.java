package ar.edu.unlam.dominio;

public class Vacuna {
	
	private Tipo TipoDeVacuna;

	public Vacuna (Tipo tipoDeVacuna) {
		TipoDeVacuna = tipoDeVacuna;
	}

	public Tipo getTipoDeVacuna() {
		return TipoDeVacuna;
	}

	public void setTipoDeVacuna(Tipo tipoDeVacuna) {
		TipoDeVacuna = tipoDeVacuna;
	}
	
	
}
