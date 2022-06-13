package rondon.com.Servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rondon.com.Interfaz.IMascota;
import rondon.com.Modelo.Mascota;

@Service
public class MascotaServiceImp implements MascotaService{
	@Autowired
	private IMascota repository;
	
	@Override
	public Collection<Mascota> listarMascota() {
		// TODO Auto-generated method stub
		return (Collection<Mascota>) repository.findAll();
	}

	@Override
	@Transactional
	public void insertar(Mascota Mascota) {
		repository.save(Mascota);
		
	}

	@Override
	@Transactional
	public void modificar(Mascota Mascota) {
		repository.save(Mascota);		
		
	}
	

	@Override
	@Transactional
	public void eliminar(Integer MascotaId) {
		repository.deleteById(MascotaId); 
		
	}

	@Override
	@Transactional
	public Mascota buscar(Integer MascotaId) {
		// TODO Auto-generated method stub
		return repository.findById(MascotaId).orElse(null);
	}
}
