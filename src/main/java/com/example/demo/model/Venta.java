package com.example.demo.model;


import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Venta {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long codigoVenta;
	private LocalDate fechaVenta;
	private Double total;
	
	@OneToMany
	private List<Producto> listaProductos;
	
	
	@OneToOne
	@JoinColumn(name="un_cliente_id_cliente", referencedColumnName= "id_cliente")
	private Cliente unCliente;
	
	
	
	
}
