package com.banco.micro.persona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banco.micro.commons.persona.dto.UsuarioDTO;
import com.banco.micro.commons.persona.entity.PerCliente;
import com.banco.micro.persona.servicio.ISvcPersona;
import com.banco.micro.persona.util.PersonaUtil;

@RestController
public class ClienteController {
    @Autowired
	private ISvcPersona svcPersona;

	@GetMapping("/listar_cliente")
	public ResponseEntity<?> getClienteFull() {
		try {
			List<PerCliente> lstCliente = svcPersona.getClienteFull();
			return ResponseEntity.ok().body(lstCliente);
		} catch (Exception e) {
			return new ResponseEntity<>(PersonaUtil.getMensajeError("ERROR AL LISTAR Cliente", e),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    /***************************/
	/******** GUARDADO *********/
	/***************************/
	@PostMapping("/guardar_usuario")
	public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		try {
			svcPersona.guardarUsuario(usuarioDTO);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(PersonaUtil.getMensajeError("ERROR AL GUARDAR USUARIO", e),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
