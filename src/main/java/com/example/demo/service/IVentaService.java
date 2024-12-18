package com.example.demo.service;


import java.time.LocalDate;
import java.util.List;



import com.example.demo.model.Producto;
import com.example.demo.model.Venta;

public interface IVentaService {

	public void saveVenta(Venta venta);
	
	public List<Venta> getVentas();
	
	public Venta findVenta(Long id);
	
	public void deleteVenta(Long id);
	
	public void editVenta(Long id_original, Long nuevaId, LocalDate nuevaFechaVenta, Double nuevoTotal);
	
	public List<Producto> getProductosAsociados(Long codigoVenta);
	
	public String ventasPorFecha(LocalDate fechaVenta);
	
	public String getMayorVenta();

	public void editVentas(Venta venta);
	
}
