package com.banco.micro.commons.persona.dto;

import java.io.Serializable;

import com.banco.micro.commons.persona.enumeracion.Genero;

public class UsuarioDTO implements Serializable{
// Datos de la persona
    private Integer personaCodigo;
    private String personaNombre;
    private Genero personaGenero;
    private Integer personaEdad;
    private String personaIdentificacion;
    private String personaDireccion;
    private String personaTelefono;

    // Datos del cliente
    private Integer clienteCodigo;
    private String clienteClave;
    private Boolean clienteEstado;

    public Integer getPersonaCodigo() {
        return personaCodigo;
    }

    public void setPersonaCodigo(Integer personaCodigo) {
        this.personaCodigo = personaCodigo;
    }

    public String getPersonaNombre() {
        return personaNombre;
    }

    public void setPersonaNombre(String personaNombre) {
        this.personaNombre = personaNombre;
    }

    public Genero getPersonaGenero() {
        return personaGenero;
    }

    public void setPersonaGenero(Genero personaGenero) {
        this.personaGenero = personaGenero;
    }

    public Integer getPersonaEdad() {
        return personaEdad;
    }

    public void setPersonaEdad(Integer personaEdad) {
        this.personaEdad = personaEdad;
    }

    public String getPersonaIdentificacion() {
        return personaIdentificacion;
    }

    public void setPersonaIdentificacion(String personaIdentificacion) {
        this.personaIdentificacion = personaIdentificacion;
    }

    public String getPersonaDireccion() {
        return personaDireccion;
    }

    public void setPersonaDireccion(String personaDireccion) {
        this.personaDireccion = personaDireccion;
    }

    public String getPersonaTelefono() {
        return personaTelefono;
    }

    public void setPersonaTelefono(String personaTelefono) {
        this.personaTelefono = personaTelefono;
    }

    public Integer getClienteCodigo() {
        return clienteCodigo;
    }

    public void setClienteCodigo(Integer clienteCodigo) {
        this.clienteCodigo = clienteCodigo;
    }

    public String getClienteClave() {
        return clienteClave;
    }

    public void setClienteClave(String clienteClave) {
        this.clienteClave = clienteClave;
    }

    public Boolean getClienteEstado() {
        return clienteEstado;
    }

    public void setClienteEstado(Boolean clienteEstado) {
        this.clienteEstado = clienteEstado;
    }

   


}
