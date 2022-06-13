package rondon.com.Servicio;

import java.util.Collection;

import rondon.com.Modelo.Mascota;

public interface MascotaService {
	public abstract Collection<Mascota> listarMascota();
	public abstract void insertar(Mascota mascota);
	public abstract void modificar(Mascota mascota);
	public abstract void eliminar(Integer mascotaId);
	public abstract Mascota buscar(Integer mascotaId);
}
