package rondon.com.Servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rondon.com.Interfaz.IEmpleado;
import rondon.com.Modelo.Empleado;

@Service
public class EmpleadoServiceImplement implements EmpleadoService{

	@Autowired
	private IEmpleado repository;
	
	@Override
	public Collection<Empleado> listarEmpleado() {
		// TODO Auto-generated method stub
		return (Collection<Empleado>) repository.findAll();
	}

	@Override
	@Transactional
	public void insertar(Empleado empleado) {
		repository.save(empleado);
		
	}

	@Override
	@Transactional
	public void modificar(Empleado bicicleta) {
		repository.save(bicicleta);		
		
	}
	

	@Override
	@Transactional
	public void eliminar(Integer empleadoId) {
		repository.deleteById(empleadoId); 
		
	}

	@Override
	@Transactional
	public Empleado buscar(Integer empleadoId) {
		// TODO Auto-generated method stub
		return repository.findById(empleadoId).orElse(null);
	}
}
