package com.example.demo.entities;


	import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

	@Entity
	public class Persona extends EntidadGenerica implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@Column(name = "nombre")
		private String nombre;
		
		@Column(name = "apellido")
		private String apellido;
		
		@Column(name = "dni")
		private int dni;

		@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinColumn(name="domicilio_id")
		private Domicilio domicilio;
		
		//constructor
		public Persona() {}
		
		public Persona(String nombre, String apellido, int dni, Domicilio domicilio) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.dni = dni;
			this.domicilio = domicilio;
		}
		
		

		
		
		//setters y getters
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public int getDni() {
			return dni;
		}

		public void setDni(int dni) {
			this.dni = dni;
		}

		public Domicilio getDomicilio() {
			return domicilio;
		}

		public void setDomicilio(Domicilio domicilio) {
			this.domicilio = domicilio;
		}

		
		
}
