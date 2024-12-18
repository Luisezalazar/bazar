package com.example.demo.controller;

import java.time.LocalDate;
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
import com.example.demo.model.Venta;
import com.example.demo.service.IVentaService;

@RestController
public class VentaController {

	@Autowired
	private IVentaService ventaServ;
	
	@GetMapping("/venta/get")
	public List<Venta> getVentas(){
		return ventaServ.getVentas();
	}
	@PostMapping("/venta/create")
	public String createVenta(@RequestBody Venta venta) {
		ventaServ.saveVenta(venta);
		return "Sale successfully created";
	}
	@PutMapping("/venta/edit/{id_original}")
	public Venta editVenta(@PathVariable Long id_original,
							@RequestParam(required=false, name="codigoVenta") Long nuevaId,
							@RequestParam(required=false, name="fechaVenta") LocalDate nuevaFechaVenta,
							@RequestParam(required=false, name="total") Double nuevoTotal) {
		ventaServ.editVenta(id_original, nuevaId, nuevaFechaVenta, nuevoTotal);
		Venta venta = ventaServ.findVenta(nuevaId);
		return venta;
							
	}
	
	@DeleteMapping("/venta/delete/{id}")
	public String deleteVenta(@PathVariable Long id) {
		ventaServ.deleteVenta(id);
		return "Sale sucessfully deleted";
	}
	
	@GetMapping("/venta/producto/{codigoVenta}")
	public List<Producto> getVentaProducto(@PathVariable Long codigoVenta){
		return ventaServ.getProductosAsociados(codigoVenta);
	}
	
	@GetMapping("/venta/{fechaVenta}")
	public String getVentaFecha(@PathVariable LocalDate fechaVenta) {
		return ventaServ.ventasPorFecha(fechaVenta);
	}
	
	@GetMapping("/venta/mayor_venta")
	public String getMayorVenta() {
		return ventaServ.getMayorVenta();
		
	}

	@PutMapping("/venta/editar")
	public Venta editVentas(@RequestBody Venta venta) {
		ventaServ.editVentas(venta);
		return ventaServ.findVenta(venta.getCodigoVenta());
	}
}
