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

import rondon.com.Modelo.Articulo;
import rondon.com.Servicio.ArticuloService;

@RestController
@RequestMapping("/Articulo")
public class ArticuloController {
	@Autowired
	private ArticuloService servicio;
	
	@GetMapping("/listar") // Http Method GET
	public ResponseEntity<?> listar() {
		Collection<Articulo> itemsArticulo = servicio.listarArticulo();
		return new ResponseEntity<>(itemsArticulo, HttpStatus.OK); // Http status code
	}
	
	@GetMapping("/buscar/{articuloId}") // Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer articuloId) {
		Articulo articuloDb = servicio.buscar(articuloId);

		if (articuloDb != null) {
			return new ResponseEntity<>(articuloDb, HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}

	@PostMapping("/agregar") // Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Articulo articulo) {
		servicio.insertar(articulo);
		return new ResponseEntity<Void>(HttpStatus.CREATED); // Http status code
	}

	@PutMapping("/editar/{articuloId}") // Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer articuloId, @RequestBody Articulo newArticulo) {
		Articulo articuloDb = servicio.buscar(articuloId);

		if (articuloDb != null) {
			articuloDb.setNombre(newArticulo.getNombre());
			articuloDb.setPre_com(newArticulo.getPre_com());
			articuloDb.setPre_vent(newArticulo.getPre_vent());
			articuloDb.setStock(newArticulo.getStock());
			articuloDb.setFvenc(newArticulo.getFvenc());
			articuloDb.setImage(newArticulo.getImage());
			articuloDb.setEstado(newArticulo.getEstado());
			articuloDb.setProveedor(newArticulo.getProveedor());
			
			servicio.modificar(articuloDb);
			return new ResponseEntity<Void>(HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}

	@DeleteMapping("/borrar/{articuloId}") // Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer articuloId) {
		Articulo articuloDb = servicio.buscar(articuloId);

		if (articuloDb != null) {
			servicio.eliminar(articuloId);
			return new ResponseEntity<Void>(HttpStatus.OK); // Http status code
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); // Http status code
	}
}
