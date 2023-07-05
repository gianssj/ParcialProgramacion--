package com.cooweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cooweb.models.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class usuarioDaoImp implements usuarioDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Usuario> obtenerUsuarios() {
		
		String query = "from Usuario";
		
		return entityManager.createQuery(query).getResultList();
	}

}
