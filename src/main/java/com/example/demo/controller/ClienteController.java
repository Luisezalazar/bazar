package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;
import com.example.demo.service.IClienteService;

@RestController
public class ClienteController {

	@Autowired
	private IClienteService clienteServ;
	
	@GetMapping("/cliente/get")
	public List<Cliente> getClientes(){
		return clienteServ.getClientes();
	}
	
	@PostMapping("/cliente/create")
	public String createCliente(@RequestBody Cliente cliente) {
		clienteServ.saveCliente(cliente);
		return "Cliente created successfully";
	}
	
	@PutMapping("/cliente/edit/{id_original}")
	public Cliente editCliente(@PathVariable Long id_original,
								@RequestParam(required=false, name="idCliente") Long nuevaId,
								@RequestParam(required=false, name="nombre") String nuevoNombre,
								@RequestParam(required=false, name="apellido") String nuevoApellido,
								@RequestParam(required=false, name="dni") String nuevoDni) {
		clienteServ.editCliente(id_original, nuevaId, nuevoNombre, nuevoApellido, nuevoDni);
		Cliente cliente = clienteServ.findCliente(nuevaId);
		return cliente;
		
	}
	
	@DeleteMapping("/cliente/delete/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		clienteServ.deleteCliente(id);
		return "Customer deleted successfully";
	}
	
	@PutMapping("/cliente/edit")
	public Cliente editClientes(@RequestBody Cliente cliente) {
		clienteServ.editCliente(cliente);
		return clienteServ.findCliente(cliente.getId_cliente());
	}
	
	
	
	
	
}
