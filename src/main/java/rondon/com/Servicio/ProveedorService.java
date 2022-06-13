package rondon.com.Servicio;

import java.util.Collection;

import rondon.com.Modelo.Proveedor;

public interface ProveedorService {
	public abstract Collection<Proveedor> listarProveedor();
	public abstract void insertar(Proveedor proveedor);
	public abstract void modificar(Proveedor proveedor);
	public abstract void eliminar(Integer proveedorId);
	public abstract Proveedor buscar(Integer proveedorId);
}
