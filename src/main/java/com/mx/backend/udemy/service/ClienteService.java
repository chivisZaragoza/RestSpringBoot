package com.mx.backend.udemy.service;

import java.util.List;

import com.mx.backend.udemy.entity.Cliente;

public interface ClienteService {

	public List<Cliente> getClietes();

	public Cliente findById(Long id);
	
	public Cliente save (Cliente cliente);
	
	public void delete (Long id);
	
}
