package rondon.com.Servicio;

import java.util.Collection;

import rondon.com.Modelo.Cita;

public interface CitaService {
	public abstract Collection<Cita> listarCita();
	public abstract void insertar(Cita cita);
	public abstract void modificar(Cita cita);
	public abstract void eliminar(Integer citaId);
	public abstract Cita buscar(Integer citaId);
}
