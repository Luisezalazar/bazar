package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.IClienteRepository;


@Service
public class ClienteService implements IClienteService{


	@Autowired
	private IClienteRepository clienteRepo;
	
	
	@Override
	public List<Cliente> getClientes() {
		List<Cliente> listaClientes = clienteRepo.findAll();
		return listaClientes;
	}

	@Override
	public void saveCliente(Cliente cliente) {
		clienteRepo.save(cliente);
		
	}

	@Override
	public Cliente findCliente(Long id) {
		Cliente cliente =  clienteRepo.findById(id).orElse(null);
		return cliente;
	}

	@Override
	public void deleteCliente(Long id) {
		clienteRepo.deleteById(id);
	}

	@Override
	public void editCliente(Long id_original, Long idNueva, String nuevoNombre, String nuevoApellido, String dni) {
		Cliente cliente = this.findCliente(id_original);
		
		cliente.setId_cliente(idNueva);
		cliente.setNombre(nuevoNombre);
		cliente.setApellido(nuevoApellido);
		cliente.setDni(dni);
		
		this.saveCliente(cliente);
	}

	@Override
	public void editCliente(Cliente cliente) {
		this.saveCliente(cliente);
		
	}

	

}
