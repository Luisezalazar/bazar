package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long codigoProducto;
	private String nombre;
	private String marca;
	private Double costo;
	private Double cantidadDisponible;
	
}
