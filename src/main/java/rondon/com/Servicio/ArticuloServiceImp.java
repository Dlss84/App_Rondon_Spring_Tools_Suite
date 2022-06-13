package rondon.com.Servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rondon.com.Interfaz.IArticulo;
import rondon.com.Modelo.Articulo;

@Service
public class ArticuloServiceImp implements ArticuloService{

	@Autowired
	private IArticulo repository;
	
	@Override
	public Collection<Articulo> listarArticulo() {
		// TODO Auto-generated method stub
		return (Collection<Articulo>) repository.findAll();
	}

	@Override
	@Transactional
	public void insertar(Articulo articulo) {
		repository.save(articulo);
		
	}

	@Override
	@Transactional
	public void modificar(Articulo articulo) {
		repository.save(articulo);		
		
	}
	

	@Override
	@Transactional
	public void eliminar(Integer articuloId) {
		repository.deleteById(articuloId); 
		
	}

	@Override
	@Transactional
	public Articulo buscar(Integer articuloId) {
		// TODO Auto-generated method stub
		return repository.findById(articuloId).orElse(null);
	}
}
