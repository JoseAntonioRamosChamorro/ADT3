package HibernatePojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Generated 4 dic. 2020 17:55:02 by Hibernate Tools 5.4.21.Final

/**
 * Clientes generated by hbm2java
 */

@Entity
@Table (name = "hotel", schema = "Clientes")

public class Clientes implements java.io.Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "idCliente")
	
	private static final long serialVersionUID = 1L;
	private Integer idCliente;
	private String nombre;
	private String apellidos;
	private String email;
	private String dni;
	private String clave;

	public Clientes() {
	}

	public Clientes(String nombre, String apellidos, String email, String dni, String clave) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.dni = dni;
		this.clave = clave;
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
