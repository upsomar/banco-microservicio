package com.banco.micro.cuenta.servicio;

import java.util.Date;
import java.util.List;

import com.banco.micro.commons.cuenta.dto.CuentaMovimientoDTO;
import com.banco.micro.commons.cuenta.dto.MovimientoReporteDTO;
import com.banco.micro.commons.cuenta.entity.BanCuenta;



public interface ISvcCuenta {

    BanCuenta guardarCuenta(BanCuenta cuenta);

    void guardarCuentaMovimiento(CuentaMovimientoDTO cuentaMovimiento);

    List<MovimientoReporteDTO> generarReporteMovimientos(Date fechaDesde, Date fechaHasta, String personaIdentificacion);

	
	
}
