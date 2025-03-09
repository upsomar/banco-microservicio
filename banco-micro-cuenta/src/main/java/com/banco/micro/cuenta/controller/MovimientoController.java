package com.banco.micro.cuenta.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banco.micro.commons.cuenta.dto.CuentaMovimientoDTO;
import com.banco.micro.cuenta.servicio.ISvcCuenta;
import com.banco.micro.cuenta.util.CuentaUtil;

@RestController
public class MovimientoController {
    @Autowired
    private ISvcCuenta svcCuenta;

    /***************************/
    /******** GUARDADO *********/
    /***************************/
    @PostMapping("/guardar_cuenta_movimiento")
    public ResponseEntity<?> guardarCuenta(@RequestBody CuentaMovimientoDTO cuentaMovimiento) {
        try {
            svcCuenta.guardarCuentaMovimiento(cuentaMovimiento);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(CuentaUtil.getMensajeError("ERROR AL GUARDAR CUENTA MOVIMIENTO", e),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reporte")
    public ResponseEntity<?> getReporteMovimientos(
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin,
            @RequestParam String personaIdentificacion) {
        try {
            Date fechaDesde = CuentaUtil.convertirStringADate(fechaInicio);
            Date fechaHasta = CuentaUtil.convertirStringADate(fechaFin);
            return ResponseEntity.ok().body(svcCuenta.generarReporteMovimientos(fechaDesde, fechaHasta, personaIdentificacion));
        } catch (Exception e) {
            return new ResponseEntity<>(
                    CuentaUtil.getMensajeError("ERROR AL CONSULTAR REPORTE MOVIMIENTO", e),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
