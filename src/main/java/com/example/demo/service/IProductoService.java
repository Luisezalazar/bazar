package com.example.demo.service;

import java.util.List;



import com.example.demo.model.Producto;

public interface IProductoService {

	public List<Producto> getProductos();
	
	public void saveProducto(Producto producto);
	
	public Producto findProducto(Long id);
	
	public void deleteProducto(Long id);
	
	public void editProducto(Long id_original, Long nuevaId, String nuevoNombre, String nuevaMarca, Double nuevoCosto, Double nuevaCantidad);
	
	public List<Producto> getAlerta();

	public void editProducto(Producto producto);
	
}
