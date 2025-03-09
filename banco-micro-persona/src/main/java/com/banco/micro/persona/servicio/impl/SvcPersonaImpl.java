package com.banco.micro.persona.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.banco.micro.commons.persona.dto.UsuarioDTO;
import com.banco.micro.commons.persona.entity.PerCliente;
import com.banco.micro.commons.persona.entity.PerPersona;
import com.banco.micro.persona.dao.IPerClienteDAO;
import com.banco.micro.persona.dao.IPerPersonaDAO;
import com.banco.micro.persona.servicio.ISvcPersona;
import com.banco.micro.persona.util.BancoException;

@Service
public class SvcPersonaImpl implements ISvcPersona {
	private final Logger log = LoggerFactory.getLogger(SvcPersonaImpl.class);

	@Autowired
	private IPerPersonaDAO personaDAO;
	@Autowired
	private IPerClienteDAO perClienteDAO;

	@Override
	public List<PerPersona> getPersonasFull() {
		try {
			return personaDAO.findAll();
		} catch (Exception e) {
			log.error("ERROR AL GUARDAR PERSONA: ", e);
			throw new BancoException().new FindingException("LISTAR PERSONAS: ", e);
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public PerPersona guardarPersona(PerPersona perPersona) {
		try {
			perPersona.setPersonaCodigo(null);
			procesarGuardadoPersona(perPersona);
			return perPersona;
		} catch (Exception e) {
			log.error("ERROR AL GUARDAR PERSONA: ", e);
			throw new BancoException(e);
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public PerPersona actualizarPersona(Integer id, PerPersona persona) {
		try {
			PerPersona personaActualizar = getPerPersonaByCodigo(id);
			personaActualizar.setPersonaNombre(persona.getPersonaNombre());
			personaActualizar.setPersonaGenero(persona.getPersonaGenero());
			personaActualizar.setPersonaEdad(persona.getPersonaEdad());
			personaActualizar.setPersonaIdentificacion(persona.getPersonaIdentificacion());
			personaActualizar.setPersonaDireccion(persona.getPersonaDireccion());
			personaActualizar.setPersonaTelefono(persona.getPersonaTelefono());
			procesarGuardadoPersona(personaActualizar);
			return personaActualizar;
		} catch (Exception e) {
			log.error("ERROR AL ACTUALIZAR PERSONA: ", e);
			throw new BancoException(e);
		}
	}

	@Override
	public PerPersona getPerPersonaByCodigo(Integer personaCondigo) {
		return personaDAO.findById(personaCondigo)
				.orElseThrow(() -> new BancoException("PERSONA POR ID: " + personaCondigo));
	}

	private void procesarGuardadoPersona(PerPersona perPersona) {
		try {
			personaDAO.save(perPersona);
		} catch (Exception e) {
			log.error("GUARDAR PERSONA: ", e);
			throw new BancoException().new NotSaveException("GUARDAR PERSONA", e);
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public void guardarUsuario(UsuarioDTO usuarioDTO) {
		try {
			PerPersona persona = getCargarPersonaDesdeDto(usuarioDTO);
			PerCliente cliente = new PerCliente();
			cliente.setPersonaCodigo(persona.getPersonaCodigo());
			cliente.setClienteClave(usuarioDTO.getClienteClave());
			cliente.setClienteEstado(usuarioDTO.getClienteEstado());
			procesarGuardarCliente(cliente);
		} catch (Exception e) {
			log.error("ERROR AL GUARDAR NUEVO USUARIO: ", e);
			throw new BancoException(e);
		}
	}

	private void procesarGuardarCliente(PerCliente cliente) {
		try {
			perClienteDAO.save(cliente);
		} catch (Exception e) {
			log.error("GUARDAR CLIENTE: ", e);
			throw new BancoException().new NotSaveException("GUARDAR CLIENTE", e);
		}
	}

	private PerPersona getCargarPersonaDesdeDto(UsuarioDTO usuarioDTO) {
		try {
			Optional<PerPersona> persona = Optional.ofNullable(usuarioDTO.getPersonaCodigo())
			.flatMap(personaCodigo -> personaDAO.findById(personaCodigo));
			if (persona.isPresent()) {
				return persona.get();
			}
			PerPersona personaNueva = new PerPersona();
			personaNueva.setPersonaNombre(usuarioDTO.getPersonaNombre());
			personaNueva.setPersonaGenero(usuarioDTO.getPersonaGenero());
			personaNueva.setPersonaEdad(usuarioDTO.getPersonaEdad());
			personaNueva.setPersonaIdentificacion(usuarioDTO.getPersonaIdentificacion());
			personaNueva.setPersonaDireccion(usuarioDTO.getPersonaDireccion());
			personaNueva.setPersonaTelefono(usuarioDTO.getPersonaTelefono());
			procesarGuardadoPersona(personaNueva);
			return personaNueva;
		} catch (Exception e) {
			log.error("ERROR AL BUSCAR O CREAR PERSONA: ", e);
			throw new BancoException(e);
		}
	}

    @Override
    public List<PerCliente> getClienteFull() {
        try {
			return perClienteDAO.findAll();
		} catch (Exception e) {
			log.error("BUSCAR CLIENTE: ", e);
			throw new BancoException().new FindingException("BUSCAR CLIENTE", e);
		}
    }

	

}
