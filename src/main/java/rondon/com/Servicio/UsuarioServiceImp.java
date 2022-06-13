package rondon.com.Servicio;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rondon.com.Interfaz.IUsuario;
import rondon.com.Modelo.Usuario;

@Service
public class UsuarioServiceImp implements UsuarioService {

	// private final EntityManager entityManager;

	@Autowired
	private IUsuario repository;

	@Override
	public Collection<Usuario> listarUsuario() {
		// TODO Auto-generated method stub
		return (Collection<Usuario>) repository.findAll();
	}

	@Override
	public void insertar(Usuario usuario) {
		repository.save(usuario);
	}

	@Override
	public void modificar(Usuario usuario) {
		repository.save(usuario);
	}

	@Override
	public void eliminar(Integer usuarioId) {
		repository.deleteById(usuarioId);

	}

	@Override
	public Usuario buscar(Integer usuarioId) {
		// TODO Auto-generated method stub
		return repository.findById(usuarioId).orElse(null);
	}

	private final EntityManager entityManager;

	@Autowired
	public UsuarioServiceImp(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Autowired
	private IUsuario iUsuario;

	@Override
	public Usuario getUser(Usuario usuarioDetalles) {
		TypedQuery<Usuario> typedQuery = entityManager
				.createQuery("FROM Usuario WHERE pass = :pass AND non_user= :non_user", Usuario.class);
		try {
			Usuario user = typedQuery.setParameter("pass", usuarioDetalles.getPass())
					.setParameter("non_user", usuarioDetalles.getNom_user()).getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Usuario insertIntoDatabase(Usuario usuario) {
		return iUsuario.save(usuario);
	}

}