package rondon.com.Servicio;

import java.util.Collection;

import rondon.com.Modelo.Empleado;

public interface EmpleadoService {
	public abstract Collection<Empleado> listarEmpleado();
	public abstract void insertar(Empleado Empleado);
	public abstract void modificar(Empleado Empleado);
	public abstract void eliminar(Integer EmpleadoId);
	public abstract Empleado buscar(Integer EmpleadoId);
}
