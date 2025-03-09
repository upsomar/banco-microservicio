package com.banco.micro.cuenta.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.banco.micro.commons.persona.entity.PerPersona;

@FeignClient("servicio-persona")
public interface IPersonaClientRest {
	
	@GetMapping("/persona_by_id/{id}")
	public PerPersona getPersonaById(@PathVariable Integer id);
	
	@GetMapping("/persona_identificacion/{idPersona}")
	public PerPersona getPersonaIdentificacionByIdPersona(@PathVariable Integer idPersona);

	

	

}
