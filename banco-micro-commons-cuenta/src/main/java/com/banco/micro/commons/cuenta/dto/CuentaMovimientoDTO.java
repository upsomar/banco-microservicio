package com.banco.micro.commons.cuenta.dto;

import java.io.Serializable;

import com.banco.micro.commons.cuenta.enumeracion.TipoMovimiento;


public class CuentaMovimientoDTO implements Serializable {
    private String cuentaNumero;

    private TipoMovimiento movimientoTipo;

    private Double movimientoValor;

    private Double movimientoSaldo;

    public String getCuentaNumero() {
        return cuentaNumero;
    }

    public void setCuentaNumero(String cuentaNumero) {
        this.cuentaNumero = cuentaNumero;
    }

    public TipoMovimiento getMovimientoTipo() {
        return movimientoTipo;
    }

    public void setMovimientoTipo(TipoMovimiento movimientoTipo) {
        this.movimientoTipo = movimientoTipo;
    }

    public Double getMovimientoValor() {
        return movimientoValor;
    }

    public void setMovimientoValor(Double movimientoValor) {
        this.movimientoValor = movimientoValor;
    }

    public Double getMovimientoSaldo() {
        return movimientoSaldo;
    }

    public void setMovimientoSaldo(Double movimientoSaldo) {
        this.movimientoSaldo = movimientoSaldo;
    }


}
