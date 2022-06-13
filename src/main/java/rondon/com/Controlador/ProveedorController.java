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

import rondon.com.Modelo.Proveedor;
import rondon.com.Servicio.ProveedorService;

@RestController
@RequestMapping("/Proveedor")
public class ProveedorController {
	@Autowired
	private ProveedorService servicio;
	
	@GetMapping("/listar") // Http Method GET
	public ResponseEntity<?> listar() {
		Collection<Proveedor> itemsProveedor = servicio.listarProveedor();
		return new ResponseEntity<>(itemsProveedor, HttpStatus.OK); // Http status code
	}
	
	@GetMapping("/buscar/{proveedorId}") // Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer proveedorId) {
		Proveedor ProveedorDb = servicio.buscar(proveedorId);

		if (ProveedorDb != null) {
			return new ResponseEntity<>(ProveedorDb, HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}

	@PostMapping("/agregar") // Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Proveedor Proveedor) {
		servicio.insertar(Proveedor);
		return new ResponseEntity<Void>(HttpStatus.CREATED); // Http status code
	}

	@PutMapping("/editar/{proveedorId}") // Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer proveedorId, @RequestBody Proveedor newProveedor) {
		Proveedor ProveedorDb = servicio.buscar(proveedorId);

		if (ProveedorDb != null) {
			ProveedorDb.setNombre(newProveedor.getNombre());
			
			ProveedorDb.setRuc(newProveedor.getRuc());
			ProveedorDb.setTelefono(newProveedor.getTelefono());
			ProveedorDb.setEmail(newProveedor.getEmail());
			ProveedorDb.setDireccion(newProveedor.getDireccion());
			ProveedorDb.setEstado(newProveedor.getEstado());
			ProveedorDb.setTip_doc(newProveedor.getTip_doc());
			ProveedorDb.setDistrito(newProveedor.getDistrito());
			
			servicio.modificar(ProveedorDb);
			return new ResponseEntity<Void>(HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}

	@DeleteMapping("/borrar/{proveedorId}") // Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer proveedorId) {
		Proveedor ProveedorDb = servicio.buscar(proveedorId);

		if (ProveedorDb != null) {
			servicio.eliminar(proveedorId);
			return new ResponseEntity<Void>(HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}
}
