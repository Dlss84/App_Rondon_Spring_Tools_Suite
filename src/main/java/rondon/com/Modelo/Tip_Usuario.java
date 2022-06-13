package rondon.com.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_usuario")
public class Tip_Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_tip_user;	
	private String tipo;

	public Tip_Usuario(Integer id_tip_user, String tipo) {
		super();
		this.id_tip_user = id_tip_user;
		this.tipo = tipo;
	}

	public Tip_Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
