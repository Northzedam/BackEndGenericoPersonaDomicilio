package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Domicilio extends EntidadGenerica implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String calle;
	
	private int numero;
	
	public Domicilio() {
		
	}

	public Domicilio(String calle, int numero) {
		
		this.calle = calle;
		this.numero = numero;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}