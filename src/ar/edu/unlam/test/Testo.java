package ar.edu.unlam.test;

import static org.junit.Assert.*;

import ar.edu.unlam.dominio.*;

public class Testo {

	@org.junit.Test
	public void queSePuedaCrearUnPaciente() {
		Integer DNI = 30545231;
		String nombre = "Rodrigo";
		String apellido = "Rodriguez";
		
		Paciente paciente = new Paciente (DNI, nombre, apellido);
		
		assertNotNull(paciente);
	}
	
	@org.junit.Test
	public void queSePuedaVacunarUnPaciente() throws Exception {
		Integer DNI = 30545231;
		String nombre = "Rodrigo";
		String apellido = "Rodriguez";
		
		Paciente paciente = new Paciente (DNI, nombre, apellido);
		
		CentroDeVacunacion centroDeVacunacion = new CentroDeVacunacion("VacunARTE");
		
		centroDeVacunacion.agregarPaciente(paciente);
		
		Vacuna vacunaCOVID_19 = new Vacuna (Tipo.COVID_19_1RA_DOSIS);
		
		assertTrue(centroDeVacunacion.aplicarVacuna(vacunaCOVID_19, paciente));
	}
	
	@org.junit.Test (expected = NoMoreVaccineException.class)
	public void queUnPacienteNoSePuedaVacunarConMasDeDosVacunasDistintas() throws Exception {
		Integer DNI = 30545231;
		String nombre = "Rodrigo";
		String apellido = "Rodriguez";
		
		Paciente paciente = new Paciente (DNI, nombre, apellido);
		
		CentroDeVacunacion centroDeVacunacion = new CentroDeVacunacion("VacunARTE");
		
		centroDeVacunacion.agregarPaciente(paciente);
		
		Vacuna vacunaCovid19 = new Vacuna (Tipo.COVID_19_1RA_DOSIS);
		Vacuna vacunaHepatitisA = new Vacuna (Tipo.HEPATITIS_A);
		Vacuna vacunaRubeola = new Vacuna (Tipo.RUBEOLA);
		
		assertTrue (centroDeVacunacion.aplicarVacuna(vacunaCovid19, paciente));
		assertTrue (centroDeVacunacion.aplicarVacuna(vacunaHepatitisA, paciente));
		assertTrue (centroDeVacunacion.aplicarVacuna(vacunaRubeola, paciente));
	}
	
	@org.junit.Test (expected = NoCovidVaccineException.class)
	public void queUnPacienteNoSePuedaAplicarLaSegundaDosisContraElCovidSiNoTieneLaPrimera() throws Exception {
		Integer DNI = 30545231;
		String nombre = "Rodrigo";
		String apellido = "Rodriguez";
		
		Paciente paciente = new Paciente (DNI, nombre, apellido);
		
		CentroDeVacunacion centroDeVacunacion = new CentroDeVacunacion("VacunARTE");
		
		centroDeVacunacion.agregarPaciente(paciente);
		
		Vacuna vacunaCOVID_19 = new Vacuna (Tipo.COVID_19_2DA_DOSIS);
		
		assertTrue(centroDeVacunacion.aplicarVacuna(vacunaCOVID_19, paciente));
	}
	
	@org.junit.Test
	public void queCuandoSeVacuneUnPacienteConDosDosisDeCovidEsteInmunizado() throws Exception {
		Integer DNI = 30545231;
		String nombre = "Rodrigo";
		String apellido = "Rodriguez";
		
		Paciente paciente = new Paciente (DNI, nombre, apellido);
		
		CentroDeVacunacion centroDeVacunacion = new CentroDeVacunacion("VacunARTE");
		
		centroDeVacunacion.agregarPaciente(paciente);
		
		Vacuna vacunaCOVID_19_PrimeraDosis = new Vacuna (Tipo.COVID_19_1RA_DOSIS);
		Vacuna vacunaCOVID_19_SegundaDosis = new Vacuna (Tipo.COVID_19_2DA_DOSIS);
		
		centroDeVacunacion.aplicarVacuna(vacunaCOVID_19_PrimeraDosis, paciente);
		centroDeVacunacion.aplicarVacuna(vacunaCOVID_19_SegundaDosis, paciente);
		
		centroDeVacunacion.agregarPacienteVacunado(paciente);
		
		Boolean esperado = true;
		Boolean persona = paciente.getEstaVacunadoContraElCovid();
		
		assertEquals (esperado, persona);
	}
	
	@org.junit.Test
	public void queUnPacienteNoSePuedaVacunarSiPadecioHepatitis() throws Exception {
		Integer DNI = 30545231;
		String nombre = "Rodrigo";
		String apellido = "Rodriguez";
		
		Paciente paciente = new Paciente (DNI, nombre, apellido);
		
		CentroDeVacunacion centroDeVacunacion = new CentroDeVacunacion("VacunARTE");
		
		centroDeVacunacion.agregarPaciente(paciente);
		
		paciente.setTuvoHepatitis(true);
		
		Vacuna vacunaContraLaHepatitisA = new Vacuna (Tipo.HEPATITIS_A);
		
		assertFalse(centroDeVacunacion.aplicarVacuna(vacunaContraLaHepatitisA, paciente));
	}
	
	@org.junit.Test
	public void queUnPacienteNoSePuedaVacunarSiPadecioRubeola() throws Exception {
		Integer DNI = 30545231;
		String nombre = "Rodrigo";
		String apellido = "Rodriguez";
		
		Paciente paciente = new Paciente (DNI, nombre, apellido);
		
		CentroDeVacunacion centroDeVacunacion = new CentroDeVacunacion("VacunARTE");
		
		centroDeVacunacion.agregarPaciente(paciente);
		
		paciente.setTuvoRubeola(true);
		
		Vacuna vacunaContraLaRubeola = new Vacuna (Tipo.RUBEOLA);
		
		assertFalse(centroDeVacunacion.aplicarVacuna(vacunaContraLaRubeola, paciente));
	}
	
	@org.junit.Test
	public void queSePuedaObtenerOrdenadosLosPacientesVacunados() {
		
	}


}
