package com.banco.micro.cuenta.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.micro.commons.cuenta.entity.BanCuenta;

import java.util.List;

import org.javers.spring.annotation.JaversSpringDataAuditable;



@JaversSpringDataAuditable
public interface IBanCuentaDAO extends JpaRepository<BanCuenta, Integer> {
	
    BanCuenta findByCuentaNumero(String cuentaNumero);

}
