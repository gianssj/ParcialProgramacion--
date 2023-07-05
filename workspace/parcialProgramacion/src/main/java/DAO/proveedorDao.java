package DAO;

import java.util.List;



import jakarta.transaction.Transactional;
import parcial.models.Proveedor;



@Transactional
public interface proveedorDao {

	
	List<Proveedor> obtenerProveedores();
		
	
} 
