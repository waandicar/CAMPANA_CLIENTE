package com.camcliente.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.camcliente.model.Cliente;
import com.camcliente.model.JPAUtil;

public class ClienteDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	/**
	 * Metodo encargado de guardar un cliente en bd
	 * 
	 * @param cliente
	 */
	public void guardarCliente(Cliente cliente) {
		entity.getTransaction().begin();
		entity.persist(cliente);
		entity.getTransaction().commit();
	}

	/**
	 * Metodo encargado de actulizar un cliente
	 * 
	 * @param cliente
	 */
	public void actualizarCliente(Cliente cliente) {
		entity.getTransaction().begin();
		entity.merge(cliente);
		entity.getTransaction().commit();
	}

	/**
	 * Metodo encragado de buscar un cliente
	 * 
	 * @param id
	 * @return
	 */
	public Cliente buscar(Long id) {
		Cliente c = new Cliente();
		c = entity.find(Cliente.class, id);
		return c;
	}

	/**
	 * Metodo encargado de eliminar un cliente
	 * 
	 * @param id
	 */
	public void eliminarCliente(Long id) {
		Cliente c = new Cliente();
		c = entity.find(Cliente.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}

	/**
	 * Metodo encragado de listar un cliente
	 * 
	 * @return
	 */
	public List<Cliente> listarClientes() {
		List<Cliente> listaClientes = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM Cliente c");
		listaClientes = q.getResultList();
		return listaClientes;
	}

}
