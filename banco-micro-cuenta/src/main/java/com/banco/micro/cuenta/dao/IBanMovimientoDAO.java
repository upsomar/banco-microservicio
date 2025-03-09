package com.banco.micro.cuenta.dao;

import java.util.Date;
import java.util.List;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.banco.micro.commons.cuenta.entity.BanMovimiento;

import jakarta.persistence.Tuple;

@JaversSpringDataAuditable
public interface IBanMovimientoDAO extends JpaRepository<BanMovimiento, Integer> {
      
    @Query(value = "SELECT m.movimiento_fecha AS fecha, "+
    "p.persona_nombre AS cliente, "+
    "c.cuenta_numero AS numeroCuenta, "+
    "CASE WHEN c.cuenta_tipo = 'A' THEN 'AHORRO' "+
    "    WHEN c.cuenta_tipo = 'C' THEN 'CORRIENTE' "+
    "END AS tipoCuenta, "+
    "c.cuenta_saldo_inicial AS saldoInicial, "+
    "c.cuenta_estado AS cuentaEstado, "+
    "CASE WHEN m.movimiento_tipo = 'D' THEN 'DEPOSITO' "+
    "    WHEN m.movimiento_tipo = 'R' THEN 'RETIRO' "+
    "END AS movimiento, "+
    "m.movimiento_valor AS valorMovimiento, "+
    "m.movimiento_saldo AS saldoDisponible "+
"FROM ban_movimiento m "+
"INNER JOIN ban_cuenta c ON m.cuenta_codigo = c.cuenta_codigo "+
"INNER JOIN per_cliente cl ON c.cliente_codigo = cl.cliente_codigo "+
"INNER JOIN per_perpersona p ON cl.persona_codigo = p.persona_codigo "+
"WHERE m.movimiento_fecha BETWEEN :fechaInicio AND :fechaFin "+
    "AND p.persona_identificacion = :identificacion ", nativeQuery = true)
List<Tuple> getReporteMovimiento(@Param("fechaInicio") Date fechaInicio,
@Param("fechaFin") Date fechaFin,
@Param("identificacion") String identificacion);
}
