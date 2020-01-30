package com.mx.backend.udemy.repository;

import org.springframework.data.repository.CrudRepository;

import com.mx.backend.udemy.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
