package com.banco.micro.commons.persona.entity;

import com.banco.micro.commons.persona.enumeracion.Genero;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "per_perpersona")
public class PerPersona {

    @Id
    @SequenceGenerator(name = "SEQ_PER_PERSONA", sequenceName = "SEQ_PER_PERSONA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PER_PERSONA")
    @Column(name = "persona_codigo")
    private Integer personaCodigo;

    @Column(name = "persona_nombre")
    private String personaNombre;

    @Column(name = "persona_genero")
    @Enumerated(EnumType.STRING)
    private Genero personaGenero;

    @Column(name = "persona_edad")
    private Integer personaEdad;

    @Column(name = "persona_identificacion")
    private String personaIdentificacion;

    @Column(name = "persona_direccion")
    private String personaDireccion;

    @Column(name = "persona_telefono")
    private String personaTelefono;

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

    
}
