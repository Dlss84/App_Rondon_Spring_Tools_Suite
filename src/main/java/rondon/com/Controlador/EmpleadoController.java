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

import rondon.com.Modelo.Empleado;
import rondon.com.Servicio.EmpleadoService;

@RestController
@RequestMapping("/Empleado")
public class EmpleadoController {
	@Autowired
	private EmpleadoService servicio;
	
	@GetMapping("/listar") // Http Method GET
	public ResponseEntity<?> listar() {
		Collection<Empleado> itemsEmpleado = servicio.listarEmpleado();
		return new ResponseEntity<>(itemsEmpleado, HttpStatus.OK); // Http status code
	}
	
	@GetMapping("/buscar/{empleadoId}") // Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer empleadoId) {
		Empleado EmpleadoDb = servicio.buscar(empleadoId);

		if (EmpleadoDb != null) {
			return new ResponseEntity<>(EmpleadoDb, HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}

	@PostMapping("/agregar") // Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Empleado Empleado) {
		servicio.insertar(Empleado);
		return new ResponseEntity<Void>(HttpStatus.CREATED); // Http status code
	}

	@PutMapping("/editar/{empleadoId}") // Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer empleadoId, @RequestBody Empleado newEmpleado) {
		Empleado EmpleadoDb = servicio.buscar(empleadoId);

		if (EmpleadoDb != null) {
			EmpleadoDb.setNombre(newEmpleado.getNombre());
			EmpleadoDb.setApell(newEmpleado.getApell());
			EmpleadoDb.setNum_doc(newEmpleado.getNum_doc());
			EmpleadoDb.setDireccion(newEmpleado.getDireccion());
			EmpleadoDb.setCorreo(newEmpleado.getCorreo());
			EmpleadoDb.setTelefono(newEmpleado.getTelefono());
			EmpleadoDb.setEstado(newEmpleado.getEstado());
			EmpleadoDb.setTipdoc(newEmpleado.getTipdoc());
			EmpleadoDb.setDistrito(newEmpleado.getDistrito());
			
			servicio.modificar(EmpleadoDb);
			return new ResponseEntity<Void>(HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}

	@DeleteMapping("/borrar/{empleadoId}") // Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer empleadoId) {
		Empleado EmpleadoDb = servicio.buscar(empleadoId);

		if (EmpleadoDb != null) {
			servicio.eliminar(empleadoId);
			return new ResponseEntity<Void>(HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}
}