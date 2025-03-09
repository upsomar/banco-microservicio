package com.banco.micro.commons.cuenta.entity;

import com.banco.micro.commons.cuenta.enumeracion.TipoCuenta;
import com.banco.micro.commons.persona.entity.PerCliente;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "ban_cuenta")
public class BanCuenta {
    @Id
    @SequenceGenerator(name = "seq_ban_cuenta", sequenceName = "seq_ban_cuenta", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ban_cuenta")
    @Column(name = "cuenta_codigo")
    private Integer cuentaCodigo;

    @Column(name = "cuenta_numero")
    private String cuentaNumero;

    @Column(name = "cuenta_tipo")
    @Enumerated(EnumType.STRING)
    private TipoCuenta cuentaTipo;

    @Column(name = "cuenta_saldo_inicial")
    private Double cuentaSaldoInicial;

    @Column(name = "cuenta_saldo_actual")
    private Double cuentaSaldoActual;

    @Column(name = "cuenta_estado")
    private Boolean cuentaEstado = true;

    @Column(name = "cliente_codigo")
    private Integer clienteCodigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_codigo", insertable = false, updatable = false)
    @JsonIgnore
    private PerCliente cliente;

    public Integer getCuentaCodigo() {
        return cuentaCodigo;
    }

    public void setCuentaCodigo(Integer cuentaCodigo) {
        this.cuentaCodigo = cuentaCodigo;
    }

    public String getCuentaNumero() {
        return cuentaNumero;
    }

    public void setCuentaNumero(String cuentaNumero) {
        this.cuentaNumero = cuentaNumero;
    }

    public Double getCuentaSaldoInicial() {
        return cuentaSaldoInicial;
    }

    public void setCuentaSaldoInicial(Double cuentaSaldoInicial) {
        this.cuentaSaldoInicial = cuentaSaldoInicial;
    }

    public Boolean getCuentaEstado() {
        return cuentaEstado;
    }

    public void setCuentaEstado(Boolean cuentaEstado) {
        this.cuentaEstado = cuentaEstado;
    }

    public Integer getClienteCodigo() {
        return clienteCodigo;
    }

    public void setClienteCodigo(Integer clienteCodigo) {
        this.clienteCodigo = clienteCodigo;
    }

    public PerCliente getCliente() {
        return cliente;
    }

    public void setCliente(PerCliente cliente) {
        this.cliente = cliente;
    }

    public TipoCuenta getCuentaTipo() {
        return cuentaTipo;
    }

    public void setCuentaTipo(TipoCuenta cuentaTipo) {
        this.cuentaTipo = cuentaTipo;
    }

    public Double getCuentaSaldoActual() {
        return cuentaSaldoActual;
    }

    public void setCuentaSaldoActual(Double cuentaSaldoActual) {
        this.cuentaSaldoActual = cuentaSaldoActual;
    }

}
