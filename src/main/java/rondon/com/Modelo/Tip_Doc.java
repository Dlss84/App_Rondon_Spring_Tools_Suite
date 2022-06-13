package rondon.com.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tip_doc")
public class Tip_Doc {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_tipdoc;
	private String nom_doc;
	
	
	public Tip_Doc(Integer id_tipdoc, String nom_doc) {
		super();
		this.id_tipdoc = id_tipdoc;
		this.nom_doc = nom_doc;
	}


	public Tip_Doc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
