package rondon.com.Controlador;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rondon.com.Modelo.Usuario;
import rondon.com.Servicio.UsuarioService;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService servicio;

	@GetMapping("/listar") // Http Method GET
	public ResponseEntity<?> listar() {
		Collection<Usuario> itemsProveedor = servicio.listarUsuario();
		return new ResponseEntity<>(itemsProveedor, HttpStatus.OK); // Http status code
	}

	@GetMapping("/buscar/{usuarioId}") // Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer usuarioId) {
		Usuario UsuarioDb = servicio.buscar(usuarioId);

		if (UsuarioDb != null) {
			return new ResponseEntity<>(UsuarioDb, HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}

	@PostMapping("/agregar") // Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Usuario usuario) {
		servicio.insertar(usuario);
		return new ResponseEntity<Void>(HttpStatus.CREATED); // Http status code
	}

	@PutMapping("/editar/{usuarioId}") // Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer usuarioId, @RequestBody Usuario newUsuario) {
		Usuario UsuarioDb = servicio.buscar(usuarioId);

		if (UsuarioDb != null) {
			UsuarioDb.setNombre(newUsuario.getNombre());
			UsuarioDb.setApellido(newUsuario.getApellido());
			UsuarioDb.setNun_doc(newUsuario.getNun_doc());
			UsuarioDb.setTelefono(newUsuario.getTelefono());
			UsuarioDb.setNom_user(newUsuario.getNom_user());
			UsuarioDb.setPass(newUsuario.getPass());
			UsuarioDb.setCorreo(newUsuario.getCorreo());
			UsuarioDb.setDireccion(newUsuario.getDireccion());
			UsuarioDb.setTip_usuario(newUsuario.getTip_usuario());
			UsuarioDb.setTip_doc(newUsuario.getTip_doc());
			UsuarioDb.setDistrito(newUsuario.getDistrito());

			servicio.modificar(UsuarioDb);
			return new ResponseEntity<Void>(HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}

	@DeleteMapping("/borrar/{usuarioId}") // Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer usuarioId) {
		Usuario UsuarioDb = servicio.buscar(usuarioId);

		if (UsuarioDb != null) {
			servicio.eliminar(usuarioId);
			return new ResponseEntity<Void>(HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}
}
