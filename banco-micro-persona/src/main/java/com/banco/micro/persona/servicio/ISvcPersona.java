package com.banco.micro.persona.servicio;

import java.util.List;

import com.banco.micro.commons.persona.dto.UsuarioDTO;
import com.banco.micro.commons.persona.entity.PerCliente;
import com.banco.micro.commons.persona.entity.PerPersona;

public interface ISvcPersona {

	List<PerPersona> getPersonasFull();

	PerPersona getPerPersonaByCodigo(Integer personaCondigo);

	PerPersona guardarPersona(PerPersona perPersona);

	PerPersona actualizarPersona(Integer id, PerPersona persona);

	void guardarUsuario(UsuarioDTO usuarioDTO);

	List<PerCliente> getClienteFull();

	

    



}
