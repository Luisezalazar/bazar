package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Cliente;


public interface IClienteService {

	public List<Cliente> getClientes();
	
	public void saveCliente(Cliente cliente);
	
	public Cliente findCliente(Long id);
	
	public void deleteCliente(Long id);
	
	public void editCliente(Long id_original, Long idNueva, String nuevoNombre, String nuevoApellido, String dni);

	public void editCliente(Cliente cliente);
	
	
}
