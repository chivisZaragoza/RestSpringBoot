package com.mx.backend.udemy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.backend.udemy.entity.Cliente;
import com.mx.backend.udemy.service.ClienteService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

	@Autowired
	private ClienteService clienteService; 
	
	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> getClientes(){
		List<Cliente> clietes = clienteService.getClietes();
		
		return new ResponseEntity<List<Cliente>>(clietes, HttpStatus.OK);
		
	}
	@GetMapping ("/clientes/{id}")
	public ResponseEntity<Cliente> findCienteById (@PathVariable("id") Long id){
		return new ResponseEntity<Cliente>(clienteService.findById(id), HttpStatus.OK);
	}
	@PostMapping("/clientes")
	public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente){
		return new ResponseEntity<Cliente>(clienteService.save(cliente), HttpStatus.CREATED);
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> updateCliente(
			@RequestBody Cliente cliente,
			@PathVariable("id") Long id){
		Cliente clienteEntity = clienteService.findById(id);
		clienteEntity.setApellido(cliente.getApellido());
		clienteEntity.setNombre(cliente.getNombre());
		clienteEntity.setEmail(cliente.getEmail());
		
		return new ResponseEntity<Cliente>(clienteService.save(clienteEntity), HttpStatus.CREATED);
	}

	@DeleteMapping ("/clientes/{id}")
	public ResponseEntity<Void> deleteCienteById (@PathVariable("id") Long id){
		clienteService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
