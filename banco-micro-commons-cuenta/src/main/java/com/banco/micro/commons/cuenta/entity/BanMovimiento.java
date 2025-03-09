package com.banco.micro.commons.cuenta.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.banco.micro.commons.cuenta.enumeracion.TipoMovimiento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "ban_movimiento")
public class BanMovimiento {
@Id
   @SequenceGenerator(name = "SEQ_BAN_MOVIMIENTO", sequenceName = "SEQ_BAN_MOVIMIENTO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BAN_MOVIMIENTO")
    @Column(name = "movimiento_codigo")
    private Integer movimientoCodigo;

    @Column(name = "movimiento_fecha")
    private Date movimientoFecha;

    @Column(name = "movimiento_tipo")
    @Enumerated(EnumType.STRING)
    private TipoMovimiento movimientoTipo;

    @Column(name = "movimiento_valor")
    private Double movimientoValor;

    @Column(name = "movimiento_saldo")
    private Double movimientoSaldo;

    @Column(name = "cuenta_codigo")
    private Integer cuentaCodigo;

    @ManyToOne
    @JoinColumn(name = "cuenta_codigo", insertable = false, updatable = false)
    @JsonIgnore    
    private BanCuenta cuenta;

    public Integer getMovimientoCodigo() {
        return movimientoCodigo;
    }

    public void setMovimientoCodigo(Integer movimientoCodigo) {
        this.movimientoCodigo = movimientoCodigo;
    }

    public Date getMovimientoFecha() {
        return movimientoFecha;
    }

    public void setMovimientoFecha(Date movimientoFecha) {
        this.movimientoFecha = movimientoFecha;
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

    public Integer getCuentaCodigo() {
        return cuentaCodigo;
    }

    public void setCuentaCodigo(Integer cuentaCodigo) {
        this.cuentaCodigo = cuentaCodigo;
    }

    public BanCuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(BanCuenta cuenta) {
        this.cuenta = cuenta;
    }


}
