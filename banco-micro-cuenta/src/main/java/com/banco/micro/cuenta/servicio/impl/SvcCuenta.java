package com.banco.micro.cuenta.servicio.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.banco.micro.commons.cuenta.dto.CuentaMovimientoDTO;
import com.banco.micro.commons.cuenta.dto.MovimientoReporteDTO;
import com.banco.micro.commons.cuenta.entity.BanCuenta;
import com.banco.micro.commons.cuenta.entity.BanMovimiento;
import com.banco.micro.commons.cuenta.enumeracion.TipoMovimiento;
import com.banco.micro.cuenta.cliente.IPersonaClientRest;
import com.banco.micro.cuenta.dao.IBanCuentaDAO;
import com.banco.micro.cuenta.dao.IBanMovimientoDAO;
import com.banco.micro.cuenta.servicio.ISvcCuenta;
import com.banco.micro.cuenta.util.BancoException;
import com.banco.micro.cuenta.util.BancoException.FindingException;
import com.banco.micro.cuenta.util.CuentaUtil;

import jakarta.persistence.Tuple;

@Service
public class SvcCuenta implements ISvcCuenta {
	private static final Logger log = LoggerFactory.getLogger(SvcCuenta.class);

	@Autowired
	private IBanCuentaDAO banCuentaDAO;
	@Autowired
	private IBanMovimientoDAO banMovimientoDAO;

	@Autowired
	private IPersonaClientRest personaClienteRest;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public BanCuenta guardarCuenta(BanCuenta cuenta) {
		try {
			cuenta.setCuentaCodigo(null);
			cuenta.setCuentaSaldoActual(cuenta.getCuentaSaldoInicial());
			procesarGuardadoCuenta(cuenta);
			return cuenta;
		} catch (Exception e) {
			log.error("ERROR AL GUARDAR CUENTA: ", e);
			throw new BancoException(e);
		}
	}

	private void procesarGuardadoCuenta(BanCuenta banCuenta) {
		try {
			banCuentaDAO.save(banCuenta);
		} catch (Exception e) {
			log.error("GUARDAR CUENTA: ", e);
			throw new BancoException().new NotSaveException("GUARDAR CUENTA", e);
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public void guardarCuentaMovimiento(CuentaMovimientoDTO cuentaMovimiento) {
		try {
			BanCuenta cuenta = getBanCuentaByCuentaNumero(cuentaMovimiento.getCuentaNumero());
			BanMovimiento movimiento = new BanMovimiento();
			movimiento.setMovimientoFecha(new Date());
			movimiento.setMovimientoTipo(cuentaMovimiento.getMovimientoTipo());
			Double saldoActual = cuenta.getCuentaSaldoActual();

			// Calcular el nuevo saldo según el tipo de movimiento
			if (TipoMovimiento.R.equals(movimiento.getMovimientoTipo())) {
				if (saldoActual < cuentaMovimiento.getMovimientoValor()) {
					throw new BancoException("Fondos insuficientes para realizar el retiro.");
				}
				movimiento.setMovimientoValor(-cuentaMovimiento.getMovimientoValor());
				saldoActual -= cuentaMovimiento.getMovimientoValor(); 
			} else {
				movimiento.setMovimientoValor(cuentaMovimiento.getMovimientoValor());
				saldoActual += cuentaMovimiento.getMovimientoValor(); 
			}

			// Asignar el nuevo saldo al movimiento
			movimiento.setMovimientoSaldo(saldoActual);

			movimiento.setCuentaCodigo(cuenta.getCuentaCodigo());
			guardarMovimientoCuenta(movimiento);
			cuenta.setCuentaSaldoActual(saldoActual);
			procesarGuardadoCuenta(cuenta);
		} catch (Exception e) {
			log.error("ERROR AL GUARDAR CUENTA MOVIMIENTO: ", e);
			throw new BancoException(e);
		}
	}

	private void guardarMovimientoCuenta(BanMovimiento movimiento) {
		try {
			banMovimientoDAO.save(movimiento);
		} catch (Exception e) {
			log.error("GUARDAR MOVIMIENTO: ", e);
			throw new BancoException().new NotSaveException("GUARDAR MOVIMIENTO", e);
		}
	}

	private BanCuenta getBanCuentaByCuentaNumero(String cuentaNumero) {
		try {
			BanCuenta cuenta = banCuentaDAO.findByCuentaNumero(cuentaNumero);
			return cuenta;
		} catch (Exception e) {
			log.error("ERROR AL CONSULTAR CUENTA POR CUENTA NUMERO: ", e);
			throw new BancoException(e);
		}
	}

    @Override
    public List<MovimientoReporteDTO> generarReporteMovimientos(Date fechaDesde, Date fechaHasta, String personaIdentificacion) {
        try {
            List<Tuple> lstAdm = banMovimientoDAO.getReporteMovimiento(
				CuentaUtil.fechaInicioCalendar(fechaDesde), 
				CuentaUtil.fechaFinCalendar(fechaHasta), personaIdentificacion);
            return CuentaUtil.convertListMapToListEntidadOrDTO(MovimientoReporteDTO.class, lstAdm);
        } catch (Exception e) {
            log.error("ADMISIONES DISPONIBLES: ", e);
            throw new BancoException().new FindingException("ERROR AL BUSCAR MOVIMIENTO DE LA CUENTA: " + e.getMessage());
        }
    }

	

}
