package com.banco.micro.persona.dao;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.micro.commons.persona.entity.PerCliente;

@JaversSpringDataAuditable
public interface IPerClienteDAO extends JpaRepository<PerCliente, Integer> {

	

}
