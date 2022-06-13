package rondon.com.Modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="venta")
public class Venta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_ven;
	private Date fe_ven;
	private Double total;
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="id_art",nullable=false,unique=true,
	foreignKey=@ForeignKey(foreignKeyDefinition = 
	"foreign key(id_art) references articulo")) 
	private Articulo articulo;
	
	@ManyToOne
	@JoinColumn(name="id_usuario",nullable=false,unique=true,
	foreignKey=@ForeignKey(foreignKeyDefinition = 
	"foreign key(id_usuario) references usuario"))	
	private Usuario usuario;

	public Venta(Integer id_ven, Date fe_ven, Double total, String estado, Articulo articulo, Usuario usuario) {
		super();
		this.id_ven = id_ven;
		this.fe_ven = fe_ven;
		this.total = total;
		this.estado = estado;
		this.articulo = articulo;
		this.usuario = usuario;
	}

	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId_ven() {
		return id_ven;
	}

	public void setId_ven(Integer id_ven) {
		this.id_ven = id_ven;
	}

	public Date getFe_ven() {
		return fe_ven;
	}

	public void setFe_ven(Date fe_ven) {
		this.fe_ven = fe_ven;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
