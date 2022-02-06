package com.camcliente.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.camcliente.dao.ClienteDAO;
import com.camcliente.model.Cliente;

@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteBean {

	/**
	 * Funcion encargada de direccionar al formulario para crear un nuevo cliente
	 * 
	 * @return
	 */
	public String nuevoCliente() {
		Cliente c = new Cliente();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return "nuevo.xhtml";
	}

	/**
	 * Funcion encragada de guardar un nuevo cliente
	 * 
	 * @param cliente
	 * @return
	 */
	public String guardarCliente(Cliente cliente) {
		//Se valida los datos ingresados por el usuario
		if(validarDatos( cliente)){
			return null;
		}else {
			Date fechaActual = new Date();
			cliente.setFecha_creacion(new java.sql.Date(fechaActual.getTime()));
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.guardarCliente(cliente);
			return "index.xhtml";
		}
	}

	/**
	 * Funcion encragada de obtener la lista de clientes
	 * 
	 * @return
	 */
	public List<Cliente> listarClientes() {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.listarClientes();
	}

	/**
	 * Funcion encargada de direccionar al formulario para modificar un nuevo
	 * cliente
	 * 
	 * @param id
	 * @return
	 */
	public String modificarCliente(Long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente c = new Cliente();
		c = clienteDAO.buscar(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return "editar.xhtml";
	}

	/**
	 * Funcion encragada de modificar un cliente
	 * 
	 * @param cliente
	 * @return
	 */
	public String actualizarCliente(Cliente cliente) {
		//Se valida los datos ingresados por el usuario
		if(validarDatos( cliente)){
			return null;
		}else {
			Date fechaActual = new Date();
			cliente.setFecha_actualizacion(new java.sql.Date(fechaActual.getTime()));
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.actualizarCliente(cliente);
			return "index.xhtml";
		}
	}

	/**
	 * Metodo encargado de validar si los datos ingresados del cliente no esten vacios
	 * 
	 * @param cliente
	 * @return
	 */
	public boolean validarDatos(Cliente cliente) {
		boolean respuesta = false;
		FacesContext totalMensajes = FacesContext.getCurrentInstance();
		
		if (cliente.getNumero_identificacion() == null || cliente.getNumero_identificacion() == 0) {
			FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Debe ingresar el numero de identificación");
			totalMensajes.addMessage(null, msg1);
			respuesta = true;
		}
		if (cliente.getPrimer_nombre() == null || cliente.getPrimer_nombre().equals("")) {
			FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Debe ingresar el primer nombre");
			totalMensajes.addMessage(null, msg1);
			respuesta = true;
		}
		if (cliente.getPrimer_apellido() == null || cliente.getPrimer_apellido().equals("")) {
			FacesMessage msg2 = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Debe ingresar el primer apellido");
			totalMensajes.addMessage(null, msg2);
			respuesta = true;
		}
		if (cliente.getCelular() == null || cliente.getCelular().equals("")) {
			FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Debe ingresar el celular");
			totalMensajes.addMessage(null, msg1);
			respuesta = true;
		}
		if (cliente.getCorreo() == null || cliente.getCorreo().equals("")) {
			FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Debe ingresar el correo");
			totalMensajes.addMessage(null, msg1);
			respuesta = true;
		}
		if (cliente.getDireccion() == null || cliente.getDireccion().equals("")) {
			FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Debe ingresar la dirección");
			totalMensajes.addMessage(null, msg1);
			respuesta = true;
		}
		return respuesta;
	}

	/**
	 * Funcion encragada de eliminar un cliente
	 * 
	 * @param id
	 * @return
	 */
	public String eliminarCliente(Long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.eliminarCliente(id);
		return "index.xhtml";
	}

}
