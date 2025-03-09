package com.banco.micro.persona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banco.micro.commons.persona.entity.PerPersona;
import com.banco.micro.persona.servicio.ISvcPersona;
import com.banco.micro.persona.util.PersonaUtil;

@RestController
public class PersonaController {

	@Autowired
	private ISvcPersona svcPersona;

	
	@GetMapping("/listar_persona")
	public ResponseEntity<?> getPersonasFull() {
		try {
			List<PerPersona> lstPersona = svcPersona.getPersonasFull();
			return ResponseEntity.ok().body(lstPersona);
		} catch (Exception e) {
			return new ResponseEntity<>(PersonaUtil.getMensajeError("ERROR AL LISTAR PERSONAS", e),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/persona_by_id/{id}")
	public ResponseEntity<?> getPersonaById(@PathVariable("id") Integer id) {
		try {
			return ResponseEntity.ok().body(svcPersona.getPerPersonaByCodigo(id));
		} catch (Exception e) {
			return new ResponseEntity<>(PersonaUtil.getMensajeError("ERROR AL CONSULTAR PERSONAS POR id", e),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	/***************************/
	/******** GUARDADO *********/
	/***************************/
	@PostMapping("/guardar_persona")
	public ResponseEntity<?> guardarPersonas(@RequestBody PerPersona perPersona) {
		try {
			PerPersona persona = svcPersona.guardarPersona(perPersona);
			return new ResponseEntity<>(persona, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(PersonaUtil.getMensajeError("ERROR AL GUARDAR PERSONA", e),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@PutMapping("/actualizar_persona/{id}")
	public ResponseEntity<?> actualizarPersonaDesdeGema(@PathVariable("id") Integer id, @RequestBody PerPersona persona) {
		try {
			return new ResponseEntity<>(svcPersona.actualizarPersona(id, persona), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(PersonaUtil.getMensajeError("ERROR AL ACTUALIZAR PERSONA", e),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
