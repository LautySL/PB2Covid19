package ar.edu.unlam.dominio;

import java.util.*;

public class CentroDeVacunacion {
	
	private String nombre;
	private ArrayList <Vacuna> vacunas;
	private Set <Paciente> pacientes, pacientesVacunados;
	
	public CentroDeVacunacion (String nombre) {
		this.nombre = nombre;
		this.vacunas = new ArrayList<>();
		this.pacientes = new HashSet<>();
		this.pacientesVacunados = new TreeSet<>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Vacuna> getVacunas() {
		return vacunas;
	}

	public void setVacunas(ArrayList<Vacuna> vacunas) {
		this.vacunas = vacunas;
	}

	public Set<Paciente> getPacientes() {
		return pacientes;
	}
	
	public Boolean agregarPacienteVacunado(Paciente paciente) {
		return this.pacientesVacunados.add(paciente);
	}

	public void setPacientes(Set<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Set<Paciente> getPacientesVacunados() {
		return pacientesVacunados;
	}

	public void setPacientesVacunados(Set<Paciente> pacientesVacunados) {
		this.pacientesVacunados = pacientesVacunados;
	}

	public Boolean aplicarVacuna (Vacuna vacuna, Paciente paciente) throws NoCovidVaccineException, NoMoreVaccineException {
		if (paciente.verificarSiYaSeAplicoLaVacuna(vacuna)) {
			return false;
		}
		if (paciente.yaSeVacunoConDosVacunas()) {
			throw new NoMoreVaccineException();
		} else {
			switch (vacuna.getTipoDeVacuna()) {
			
			case COVID_19_1RA_DOSIS:
					paciente.agregarVacunaAplicada(vacuna);
					agregarPacienteVacunado(paciente);
					return true;
			case COVID_19_2DA_DOSIS:
				if (paciente.tienePrimeraDosisContraElCovid()) {
					paciente.agregarVacunaAplicada(vacuna);
					paciente.setEstaVacunadoContraElCovid(true);
					agregarPacienteVacunado(paciente);
					return true;
					} else { 	
					 throw new NoCovidVaccineException();
					}
			case HEPATITIS_A:
				if (paciente.getTuvoHepatitis() == false) {
					paciente.agregarVacunaAplicada(vacuna);
					agregarPacienteVacunado(paciente);
					return true;
					} else {
						return false;
					}
			case HEPATITIS_B:
				if (paciente.getTuvoHepatitis() == false) {
					paciente.agregarVacunaAplicada(vacuna);
					this.agregarPacienteVacunado(paciente);
					return true;
					} 
				return false;
			case HEPATITIS_C: 
				if (paciente.getTuvoHepatitis() == false) {
					paciente.agregarVacunaAplicada(vacuna);
					agregarPacienteVacunado(paciente);
					return true;
					} 
				return false;
			case RUBEOLA:
				if (paciente.getTuvoRubeola() == false) {
					paciente.agregarVacunaAplicada(vacuna);
					agregarPacienteVacunado(paciente);
					return true;
				} 
			return false;
				default:
					break;
				}
			}
		return null;
	}
	
	public TreeSet <Paciente> ordenarPacientes() {
		TreeSet <Paciente> pacientesOrdenados = new TreeSet<>();
		
		pacientesOrdenados.addAll(pacientesVacunados);
		
		return pacientesOrdenados;
	}

	public Boolean agregarPaciente(Paciente paciente) {
		return this.pacientes.add(paciente);
	}
}
