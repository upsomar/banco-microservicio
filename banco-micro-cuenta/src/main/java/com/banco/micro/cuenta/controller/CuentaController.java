package com.banco.micro.cuenta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banco.micro.cuenta.servicio.ISvcCuenta;
import com.banco.micro.cuenta.util.CuentaUtil;
import com.banco.micro.commons.cuenta.entity.BanCuenta;

@RestController
public class CuentaController {

	@Autowired
	private ISvcCuenta svcCuenta;


	/***************************/
	/******** GUARDADO *********/
	/***************************/
	@PostMapping("/guardar_cuenta")
	public ResponseEntity<?> guardarCuenta(@RequestBody BanCuenta cuenta) {
		try {
			BanCuenta banCuenta = svcCuenta.guardarCuenta(cuenta);
			return new ResponseEntity<>(banCuenta, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(CuentaUtil.getMensajeError("ERROR AL GUARDAR CUENTA", e),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	

}
