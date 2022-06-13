package rondon.com.Servicio;

import java.util.Collection;

import rondon.com.Modelo.Articulo;


public interface ArticuloService {
	public abstract Collection<Articulo> listarArticulo();
	public abstract void insertar(Articulo articulo);
	public abstract void modificar(Articulo articulo);
	public abstract void eliminar(Integer articuloId);
	public abstract Articulo buscar(Integer articuloId);
	
}
