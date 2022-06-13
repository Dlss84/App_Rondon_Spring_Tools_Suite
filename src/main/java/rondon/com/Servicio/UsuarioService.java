package rondon.com.Servicio;

import java.util.Collection;

import org.springframework.stereotype.Component;

import rondon.com.Modelo.Usuario;

@Component
public interface UsuarioService {

	
	public abstract Collection<Usuario> listarUsuario();
	public abstract void insertar(Usuario usuario);
	public abstract void modificar(Usuario usuario);
	public abstract void eliminar(Integer usuarioId);
	public abstract Usuario buscar(Integer usuarioId);
	
	public Usuario getUser(Usuario usuario);
	public Usuario insertIntoDatabase(Usuario usuario);
}
