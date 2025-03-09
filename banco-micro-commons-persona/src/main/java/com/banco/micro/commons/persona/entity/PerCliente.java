package com.banco.micro.commons.persona.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "per_cliente")
public class PerCliente {
    
    @Id
    @SequenceGenerator(name = "SEQ_PER_CLIENTE", sequenceName = "SEQ_PER_CLIENTE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PER_CLIENTE")
    @Column(name = "cliente_codigo")
    private Integer clienteCodigo;

    @Column(name = "cliente_clave")
    private String clienteClave;

    @Column(name = "cliente_estado")
    private Boolean clienteEstado = true;

    @Column(name = "persona_codigo")
    private Integer personaCodigo;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_codigo", insertable = false, updatable = false)
    @JsonIgnore
    private PerPersona persona;

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

    public Integer getPersonaCodigo() {
        return personaCodigo;
    }

    public void setPersonaCodigo(Integer personaCodigo) {
        this.personaCodigo = personaCodigo;
    }

    public PerPersona getPersona() {
        return persona;
    }

    public void setPersona(PerPersona persona) {
        this.persona = persona;
    }


}
