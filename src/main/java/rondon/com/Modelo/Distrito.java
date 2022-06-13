package rondon.com.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="distrito")
public class Distrito {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_distrito;
	

	
	private String nombre;

	public Distrito(Integer id_distrito, String nombre) {
		super();
		this.id_distrito = id_distrito;
		this.nombre = nombre;
	}

	public Distrito() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
