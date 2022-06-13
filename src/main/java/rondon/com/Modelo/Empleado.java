package rondon.com.Modelo;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id_emp;
	
	private String nombre;
	private String apell;
	private Integer num_doc;
	private String direccion;
	private String correo;
	private Integer telefono;
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="id_tipdoc",nullable=false,unique=true,
	foreignKey=@ForeignKey(foreignKeyDefinition = 
	"foreign key(id_tipdoc) references tip_doc")) 
	private Tip_Doc tipdoc;
	
	
	@ManyToOne
	@JoinColumn(name="id_distrito",nullable=false,unique=true,
	foreignKey=@ForeignKey(foreignKeyDefinition = 
	"foreign key(id_distrito) references distrito"))
	private Distrito distrito;

	public Integer getId_emp() {
		return id_emp;
	}

	public void setId_emp(Integer id_emp) {
		this.id_emp = id_emp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApell() {
		return apell;
	}

	public void setApell(String apell) {
		this.apell = apell;
	}

	public Integer getNum_doc() {
		return num_doc;
	}

	public void setNum_doc(Integer num_doc) {
		this.num_doc = num_doc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Tip_Doc getTipdoc() {
		return tipdoc;
	}

	public void setTipdoc(Tip_Doc tipdoc) {
		this.tipdoc = tipdoc;
	}



	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public Empleado(Integer id_emp, String nombre, String apell, Integer num_doc, String direccion, String correo,
			Integer telefono, String estado, Tip_Doc tipdoc,
			Distrito distrito) {
		super();
		this.id_emp = id_emp;
		this.nombre = nombre;
		this.apell = apell;
		this.num_doc = num_doc;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		this.estado = estado;
		this.tipdoc = tipdoc;

		this.distrito = distrito;
	}

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
