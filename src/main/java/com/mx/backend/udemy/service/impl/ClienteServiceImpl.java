package com.mx.backend.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.backend.udemy.entity.Cliente;
import com.mx.backend.udemy.repository.ClienteRepository;
import com.mx.backend.udemy.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> getClietes() {
		Iterable<Cliente> findAll = clienteRepository.findAll();
		List<Cliente> clientes = new ArrayList<>();
		findAll.forEach(clientes::add);
		return clientes;
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		
		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {

		clienteRepository.deleteById(id);
	}

}
