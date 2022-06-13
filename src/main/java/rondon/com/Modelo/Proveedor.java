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
@Table(name="proveedor")
public class Proveedor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_prov;
	private String nombre;
	private String ruc;
	private Integer telefono;
	private String email;
	private String direccion;
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="id_tipdoc",nullable=false,unique=true,
	foreignKey=@ForeignKey(foreignKeyDefinition = 
	"foreign key(id_tipdoc) references tip_doc")) 
	private Tip_Doc tip_doc;
	
	@ManyToOne
	@JoinColumn(name="id_distrito",nullable=false,unique=true,
	foreignKey=@ForeignKey(foreignKeyDefinition = 
	"foreign key(id_distrito) references distrito")) 
	private Distrito distrito;
	

	public Proveedor(Integer id_prov, String nombre, String ruc, Integer telefono, String email, String direccion,
			String estado, Tip_Doc tip_doc, Distrito distrito) {
		super();
		this.id_prov = id_prov;
		this.nombre = nombre;
		this.ruc = ruc;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.estado = estado;
		this.tip_doc = tip_doc;
		this.distrito = distrito;
	}

	public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId_prov() {
		return id_prov;
	}

	public void setId_prov(Integer id_prov) {
		this.id_prov = id_prov;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Tip_Doc getTip_doc() {
		return tip_doc;
	}

	public void setTip_doc(Tip_Doc tip_doc) {
		this.tip_doc = tip_doc;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	
}
