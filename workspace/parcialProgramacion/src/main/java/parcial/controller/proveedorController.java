package parcial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DAO.proveedorDao;
import parcial.models.Proveedor;

@RestController
public class proveedorController {
	
	@Autowired
	private proveedorDao proveedorDao;
	
	@RequestMapping(value = "mensaje")
	public String mensaje() {
		return "Hola mundo";
	}
	
	@RequestMapping(value = "proveedor")
	public List<String> listarProveedores(){
		return List.of("Proveedor1", "Proveedor2", "Proveedor3");
	}
	
	@RequestMapping(value = "proveedor/{id}")
	public Proveedor getProveedor(@PathVariable Long id) {
		Proveedor proveedor = new Proveedor();
		proveedor.setId(id);
		proveedor.setNombre("Proveedor1");
		proveedor.setTelefono("123456789");
		proveedor.setEmail("proveedor1@example.com");
		
		return proveedor;
	}
	
	@RequestMapping(value = "proveedor/lista_proveedores")
	public List<Proveedor> listarVariosProveedores() {
		List<Proveedor> proveedores = new ArrayList<>();
		
		Proveedor proveedor1 = new Proveedor();
		proveedor1.setId(1L);
		proveedor1.setNombre("Proveedor1");
		proveedor1.setTelefono("123456789");
		proveedor1.setEmail("proveedor1@example.com");
		
		Proveedor proveedor2 = new Proveedor();
		proveedor2.setId(2L);
		proveedor2.setNombre("Proveedor2");
		proveedor2.setTelefono("987654321");
		proveedor2.setEmail("proveedor2@example.com");
		
		proveedores.add(proveedor1);
		proveedores.add(proveedor2);
		
		return proveedores;
	}

	@RequestMapping(value = "api/proveedores")
	public List<Proveedor> getProveedores(){
		List<Proveedor> proveedores = proveedorDao.obtenerProveedores();
		return proveedores;
	}
}
