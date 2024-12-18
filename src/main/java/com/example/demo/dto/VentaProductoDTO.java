package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class VentaProductoDTO {

	private long idVenta;
	private String nombre;
	private String marca;
	private Double costo;
	private int cantidad;
	private String nombreCliente;
	private String apellidoCliente;
}
