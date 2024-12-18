package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.Producto;
import com.example.demo.repository.IProductoRepository;

@Service
public class ProductoService implements IProductoService{

	@Autowired
	private IProductoRepository productoRepo;
	
	@Override
	public List<Producto> getProductos() {
		List<Producto> listaProducto = productoRepo.findAll();
		return listaProducto;
	}

	@Override
	public void saveProducto(Producto producto) {
		productoRepo.save(producto);
	}

	@Override
	public Producto findProducto(Long id) {
		Producto producto = productoRepo.findById(id).orElse(null);
		return producto;
	}

	@Override
	public void deleteProducto(Long id) {
		productoRepo.deleteById(id);
		
	}

	

	@Override
	public List<Producto> getAlerta() {
		
		List<Producto> listaProductos = this.getProductos();
		List<Producto> listaAlerta= new ArrayList<Producto>();
		for( Producto product : listaProductos){
			if(product.getCantidadDisponible() <= 4) {
				listaAlerta.add(product);
			}
		}
		return listaAlerta;
		
	}

	@Override
	public void editProducto(Long id_original, Long nuevaId, String nuevoNombre, String nuevaMarca, Double nuevoCosto,
			Double nuevaCantidad) {
		Producto producto = this.findProducto(id_original);
		
		producto.setCodigoProducto(nuevaId);
		producto.setNombre(nuevoNombre);
		producto.setMarca(nuevaMarca);
		producto.setCosto(nuevoCosto);
		producto.setCantidadDisponible(nuevaCantidad);
		
		this.saveProducto(producto);
		
		
	}

	@Override
	public void editProducto(Producto producto) {
		this.saveProducto(producto);
	}

	

	
}
