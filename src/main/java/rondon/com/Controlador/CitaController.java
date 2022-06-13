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

import rondon.com.Modelo.Cita;
import rondon.com.Servicio.CitaService;

@RestController
@RequestMapping("/Cita")
public class CitaController {

	@Autowired
	private CitaService servicio;
	
	@GetMapping("/listar") // Http Method GET
	public ResponseEntity<?> listar() {
		Collection<Cita> itemsCita = servicio.listarCita();
		return new ResponseEntity<>(itemsCita, HttpStatus.OK); // Http status code
	}
	
	@GetMapping("/buscar/{citaId}") // Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer citaId) {
		Cita CitaDb = servicio.buscar(citaId);

		if (CitaDb != null) {
			return new ResponseEntity<>(CitaDb, HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}

	@PostMapping("/agregar") // Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Cita cita) {
		servicio.insertar(cita);
		return new ResponseEntity<Void>(HttpStatus.CREATED); // Http status code
	}

	@PutMapping("/editar/{citaId}") // Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer citaId, @RequestBody Cita newCita) {
		Cita CitaDb = servicio.buscar(citaId);

		if (CitaDb != null) {
			
			CitaDb.setFecha(newCita.getFecha());
			CitaDb.setObservacion(newCita.getObservacion());
			CitaDb.setEstado(newCita.getEstado());
			CitaDb.setEmpleado(newCita.getEmpleado());
			CitaDb.setMascota(newCita.getMascota());
			
			
			servicio.modificar(CitaDb);
			return new ResponseEntity<Void>(HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}

	@DeleteMapping("/borrar/{citaId}") // Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer citaId) {
		Cita CitaDb = servicio.buscar(citaId);

		if (CitaDb != null) {
			servicio.eliminar(citaId);
			return new ResponseEntity<Void>(HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}
}
