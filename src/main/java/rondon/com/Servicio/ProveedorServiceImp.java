package rondon.com.Servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rondon.com.Interfaz.IProveedor;
import rondon.com.Modelo.Proveedor;

@Service
public class ProveedorServiceImp implements ProveedorService{
	@Autowired
	private IProveedor repository;
	
	@Override
	public Collection<Proveedor> listarProveedor() {
		// TODO Auto-generated method stub
		return (Collection<Proveedor>) repository.findAll();
	}

	@Override
	@Transactional
	public void insertar(Proveedor Proveedor) {
		repository.save(Proveedor);
		
	}

	@Override
	@Transactional
	public void modificar(Proveedor Proveedor) {
		repository.save(Proveedor);		
		
	}
	

	@Override
	@Transactional
	public void eliminar(Integer proveedorId) {
		repository.deleteById(proveedorId); 
		
	}

	@Override
	@Transactional
	public Proveedor buscar(Integer proveedorId) {
		// TODO Auto-generated method stub
		return repository.findById(proveedorId).orElse(null);
	}
}
