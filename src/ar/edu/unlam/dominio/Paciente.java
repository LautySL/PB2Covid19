package ar.edu.unlam.dominio;

import java.util.*;

public class Paciente implements Comparable <Paciente> {
	
	private Integer DNI;
	private String nombre, apellido;
	private Set <Vacuna> vacunasAplicadas;
	private Boolean estaVacunadoContraElCovid, tuvoHepatitis, tuvoRubeola;
	
	public Paciente (Integer dNI, String nombre, String apellido) {
		this.DNI = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tuvoHepatitis = false;
		this.tuvoRubeola = false;
		this.estaVacunadoContraElCovid = false;
		this.vacunasAplicadas = new HashSet<>();
	}
	
	public Integer getDNI() {
		return DNI;
	}
	
	public Boolean agregarVacunaAplicada (Vacuna vacuna) {
		return this.vacunasAplicadas.add(vacuna);
	}
	
	public Boolean tienePrimeraDosisContraElCovid() {
		for (Vacuna vacuna : vacunasAplicadas) {
			if (vacuna.getTipoDeVacuna().equals(Tipo.COVID_19_1RA_DOSIS)) {
				return true;
			}
		} return false;
	}

	public Boolean getTuvoHepatitis() {
		return tuvoHepatitis;
	}

	public void setTuvoHepatitis(Boolean tuvoHepatitis) {
		this.tuvoHepatitis = tuvoHepatitis;
	}

	public Boolean getTuvoRubeola() {
		return tuvoRubeola;
	}

	public void setTuvoRubeola(Boolean tuvoRubeola) {
		this.tuvoRubeola = tuvoRubeola;
	}
	
	public Boolean verificarSiYaSeAplicoLaVacuna (Vacuna vacuna) {
		for (Vacuna vacunaAplicada : vacunasAplicadas) {
			if (vacunaAplicada.getTipoDeVacuna().equals(vacuna.getTipoDeVacuna())) {
				return true;
			}
		} return false;
	}
	
	public Boolean yaSeVacunoConDosVacunas() {
		if (this.vacunasAplicadas.size() == 2) {
			return true;
		}
		return false;
	}

	public void setDNI(Integer dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Set<Vacuna> getVacunasAplicadas() {
		return vacunasAplicadas;
	}

	public void setVacunasAplicadas(Set<Vacuna> vacunasAplicadas) {
		this.vacunasAplicadas = vacunasAplicadas;
	}

	public Boolean getEstaVacunadoContraElCovid() {
		return estaVacunadoContraElCovid;
	}

	public void setEstaVacunadoContraElCovid(Boolean estaVacunadoContraElCovid) {
		this.estaVacunadoContraElCovid = estaVacunadoContraElCovid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DNI);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(DNI, other.DNI);
	}

	@Override
	public int compareTo(Paciente o) {
		return this.DNI.compareTo(o.getDNI());
	}
	
}
