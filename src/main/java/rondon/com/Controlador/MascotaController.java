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

import rondon.com.Modelo.Mascota;
import rondon.com.Servicio.MascotaService;

@RestController
@RequestMapping("/Mascota")
public class MascotaController {
	
	@Autowired
	private MascotaService servicio;
	
	@GetMapping("/listar") // Http Method GET
	public ResponseEntity<?> listar() {
		Collection<Mascota> itemsMascota = servicio.listarMascota();
		return new ResponseEntity<>(itemsMascota, HttpStatus.OK); // Http status code
	}
	
	@GetMapping("/buscar/{mascotaId}") // Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer mascotaId) {
		Mascota MascotaDb = servicio.buscar(mascotaId);

		if (MascotaDb != null) {
			return new ResponseEntity<>(MascotaDb, HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}

	@PostMapping("/agregar") // Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Mascota Mascota) {
		servicio.insertar(Mascota);
		return new ResponseEntity<Void>(HttpStatus.CREATED); // Http status code
	}

	@PutMapping("/editar/{mascotaId}") // Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer mascotaId, @RequestBody Mascota newMascota) {
		Mascota MascotaDb = servicio.buscar(mascotaId);

		if (MascotaDb != null) {
			MascotaDb.setNombre(newMascota.getNombre());
			MascotaDb.setEdad(newMascota.getEdad());
			MascotaDb.setObservacion(newMascota.getObservacion());
			MascotaDb.setEstado(newMascota.getEstado());
			MascotaDb.setUsuario(newMascota.getUsuario());
			
			servicio.modificar(MascotaDb);
			return new ResponseEntity<Void>(HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}

	@DeleteMapping("/borrar/{mascotaId}") // Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer mascotaId) {
		Mascota MascotaDb = servicio.buscar(mascotaId);

		if (MascotaDb != null) {
			servicio.eliminar(mascotaId);
			return new ResponseEntity<Void>(HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}
}
