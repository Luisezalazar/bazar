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

import com.example.demo.model.Producto;
import com.example.demo.service.IProductoService;

@RestController
public class ProductoController {
	
	@Autowired
	private IProductoService productoServ;
	
	@GetMapping("/producto/get")
	public List<Producto> getListaProducto(){
		return productoServ.getProductos();
	}
	@PostMapping("/producto/create")
	public String createProducto(@RequestBody Producto producto) {
		productoServ.saveProducto(producto);
		return "Product created successfully";
	}
	
	@PutMapping("/producto/edit/{id_original}")
	public Producto editProduc(@PathVariable Long id_original,
							@RequestParam(required=false, name="codigoProducto") long nuevaId,
							@RequestParam(required=false, name="nombre") String nuevoNombre,
							@RequestParam(required=false, name="marca") String nuevaMarca,
							@RequestParam(required=false, name="costo") Double nuevoCosto,
							@RequestParam(required=false, name="cantidadDisponible") Double nuevaCantidad) {
		productoServ.editProducto(id_original, nuevaId, nuevoNombre, nuevaMarca, nuevoCosto, nuevaCantidad);
		Producto producto = productoServ.findProducto(nuevaId);
		return producto;
		
	}
	@DeleteMapping("/producto/delete")
	public String deleteProduct (@PathVariable Long id) {
		productoServ.deleteProducto(id);
		return "Product deleted successfully";
	}
	
	@GetMapping("/producto/faltaStock")
	public List<Producto> getCantidad(){
		return productoServ.getAlerta();
	}
	
	@PutMapping("/producto/edit")
	public Producto editProductos(@RequestBody Producto producto) {
		productoServ.editProducto(producto);
		return productoServ.findProducto(producto.getCodigoProducto());
	}
	
}
