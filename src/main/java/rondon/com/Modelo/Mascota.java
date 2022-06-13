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
@Table(name="mascota")
public class Mascota {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_mas;
	private String nombre;
	private Integer edad;
	private String observacion;
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="id_usuario",nullable=false,unique=true,
	foreignKey=@ForeignKey(foreignKeyDefinition = 
	"foreign key(id_usuario) references usuario")) 
	private Usuario usuario;
	
	public Integer getId_mas() {
		return id_mas;
	}
	public void setId_mas(Integer id_mas) {
		this.id_mas = id_mas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
		
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Mascota(Integer id_mas, String nombre, Integer edad, String observacion, String estado, Usuario usuario) {
		super();
		this.id_mas = id_mas;
		this.nombre = nombre;
		this.edad = edad;
		this.observacion = observacion;
		this.estado = estado;
		this.usuario = usuario;
	}
	public Mascota() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
