package rondon.com.Interfaz;

import org.springframework.data.repository.CrudRepository;

import rondon.com.Modelo.Usuario;

public interface IUsuario extends CrudRepository<Usuario, Integer> {

}
