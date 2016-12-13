package br.com.medclin.boot;




import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import br.com.medclin.boot.models.Paciente;

public class PacienteFormatter implements Formatter<Paciente> {

	@Override
	public String print(Paciente paciente, Locale locale) {
		
		return paciente.getIdString();
	}

	

	@Override
	public Paciente parse(String id, Locale locale) throws ParseException {
		Paciente paciente = new Paciente();
		paciente.setIdString(id);
		return paciente;
		
	}
}
