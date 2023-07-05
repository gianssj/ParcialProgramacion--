package DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import parcial.models.Proveedor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class proveedorDaoImp implements proveedorDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Proveedor> obtenerProveedores() {
		
		String query = "from Proveedor";
		
		return entityManager.createQuery(query).getResultList();
	}

}
