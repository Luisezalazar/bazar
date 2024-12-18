package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.dto.VentaProductoDTO;
import com.example.demo.model.Producto;
import com.example.demo.model.Venta;
import com.example.demo.repository.IVentaRepository;


@Service
public class VentaService implements IVentaService{

	
	 @Autowired
	private IVentaRepository ventaRepo;
	
	@Override
	public void saveVenta(Venta venta) {
		ventaRepo.save(venta);
	}

	@Override
	public List<Venta> getVentas() {
		List<Venta> listaVentas = ventaRepo.findAll();
		return listaVentas;
	}

	@Override
	public Venta findVenta(Long id) {
		Venta venta = ventaRepo.findById(id).orElse(null);
		return venta;
	}

	@Override
	public void deleteVenta(Long id) {
		ventaRepo.deleteById(id);
	}

	

	@Override
	public List<Producto> getProductosAsociados(Long codigoVenta) {
		Optional<Venta> ventaOPT = ventaRepo.findById(codigoVenta);
		if(ventaOPT.isPresent()) {
			return ventaOPT.get().getListaProductos();
		}else {return null;
		}
	}

	@Override
	public String ventasPorFecha(LocalDate fechaVenta) {
		
		List<Venta> listaVentas = this.getVentas();
		Double monto=0.0;
		int totalVentas=0;
		
		
		for(Venta venta: listaVentas) {
			if(venta.getFechaVenta().equals(fechaVenta)){
				monto+= venta.getTotal();
				totalVentas++;
				
			}
		}
		return "Sale: " + monto +  "  TotalVenta: " + totalVentas;
		
		
	}

	@Override
	public String getMayorVenta() {
		
		Double monto=0.0;
		Venta ventaObjetivo=null;
		VentaProductoDTO dto = new VentaProductoDTO();
		
		List<Venta> listaVentas = this.getVentas();
		for(Venta venta: listaVentas) {
			if(venta.getTotal() > monto) {
				monto = venta.getTotal();
				ventaObjetivo = venta;
			}
		}
		
		if(ventaObjetivo!=null) {
			
			 dto.setIdVenta(ventaObjetivo.getCodigoVenta());
			 dto.setCosto(ventaObjetivo.getTotal());
			 dto.setCantidad(ventaObjetivo.getListaProductos().size());
			 dto.setNombreCliente(ventaObjetivo.getUnCliente().getNombre());
			 dto.setApellidoCliente(ventaObjetivo.getUnCliente().getApellido());
		}
		return "  Codigo venta: " + dto.getIdVenta() +
				"  Total: " + dto.getCosto() +
				"  Cantidad: " + dto.getCantidad() +
				"  Nombre Cliente: " + dto.getNombreCliente() +
				"  Apellido cliente: " + dto.getApellidoCliente();
				
	}

	@Override
	public void editVenta(Long id_original, Long nuevaId, LocalDate nuevaFechaVenta, Double nuevoTotal) {
		
		Venta venta = this.findVenta(id_original);
		
		venta.setCodigoVenta(nuevaId);
		venta.setFechaVenta(nuevaFechaVenta);
		venta.setTotal(nuevoTotal);
		
		this.saveVenta(venta);
		
	}

	@Override
	public void editVentas(Venta venta) {
		this.saveVenta(venta);
		
	}


	

	
	
}
