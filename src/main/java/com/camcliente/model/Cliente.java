package com.camcliente.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cod_cliente;
	@Column
	private Integer cod_tipo_identi;
	@Column
	private Integer numero_identificacion;
	@Column
	private String primer_nombre;
	@Column
	private String segundo_nombre;
	@Column
	private String primer_apellido;
	@Column
	private String segundo_apellido;
	@Column
	private String celular;
	@Column
	private String correo;
	@Column
	private String direccion;
	@Column
	private String autoriza_tratamiento;
	@Column
	private String estado_cliente;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_creacion;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_actualizacion;

	

	public Long getCod_cliente() {
		return cod_cliente;
	}



	public void setCod_cliente(Long cod_cliente) {
		this.cod_cliente = cod_cliente;
	}



	public Integer getCod_tipo_identi() {
		return cod_tipo_identi;
	}



	public void setCod_tipo_identi(Integer cod_tipo_identi) {
		this.cod_tipo_identi = cod_tipo_identi;
	}



	public Integer getNumero_identificacion() {
		return numero_identificacion;
	}



	public void setNumero_identificacion(Integer numero_identificacion) {
		this.numero_identificacion = numero_identificacion;
	}



	public String getPrimer_nombre() {
		return primer_nombre;
	}



	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}



	public String getSegundo_nombre() {
		return segundo_nombre;
	}



	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}



	public String getPrimer_apellido() {
		return primer_apellido;
	}



	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}



	public String getSegundo_apellido() {
		return segundo_apellido;
	}



	public void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}



	public String getCelular() {
		return celular;
	}



	public void setCelular(String celular) {
		this.celular = celular;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getAutoriza_tratamiento() {
		return autoriza_tratamiento;
	}



	public void setAutoriza_tratamiento(String autoriza_tratamiento) {
		this.autoriza_tratamiento = autoriza_tratamiento;
	}



	public String getEstado_cliente() {
		return estado_cliente;
	}



	public void setEstado_cliente(String estado_cliente) {
		this.estado_cliente = estado_cliente;
	}



	public Date getFecha_creacion() {
		return fecha_creacion;
	}



	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}






	public Date getFecha_actualizacion() {
		return fecha_actualizacion;
	}



	public void setFecha_actualizacion(Date fecha_actualizacion) {
		this.fecha_actualizacion = fecha_actualizacion;
	}



	@Override
	public String toString() {
		return "Cliente [cod_cliente=" + cod_cliente + ", cod_tipo_identi=" + cod_tipo_identi
				+ ", numero_identificacion=" + numero_identificacion + ", primer_nombre=" + primer_nombre
				+ ", segundo_nombre=" + segundo_nombre + ", primer_apellido=" + primer_apellido + ", segundo_apellido="
				+ segundo_apellido + ", celular=" + celular + ", correo=" + correo + ", direccion=" + direccion
				+ ", autoriza_tratamiento=" + autoriza_tratamiento + ", estado_cliente=" + estado_cliente
				+ ", fecha_creacion=" + fecha_creacion + ", fecha_actualizacion=" + fecha_actualizacion + "]";
	}
	
}
