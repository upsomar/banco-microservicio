package com.banco.micro.commons.cuenta.dto;

import java.util.Date;

public class MovimientoReporteDTO {

    private Date fecha;
    private String cliente;
    private String numeroCuenta;
    private String tipoCuenta;
    private Double saldoInicial;
    private Boolean cuentaEstado;
    private String movimiento;
    private Double saldoDisponible;

    public MovimientoReporteDTO() {
    }

    public MovimientoReporteDTO(Date fecha, String cliente, String numeroCuenta, String tipoCuenta, Double saldoInicial,
            Boolean cuentaEstado, String movimiento, Double saldoDisponible) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoInicial = saldoInicial;
        this.cuentaEstado = cuentaEstado;
        this.movimiento = movimiento;
        this.saldoDisponible = saldoDisponible;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Boolean getCuentaEstado() {
        return cuentaEstado;
    }

    public void setCuentaEstado(Boolean cuentaEstado) {
        this.cuentaEstado = cuentaEstado;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public Double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(Double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }


}
