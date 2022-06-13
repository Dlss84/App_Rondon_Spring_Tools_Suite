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
@Table(name="compra")
public class Compra {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_compra;
	private Date fech_comp;
	private Double total;
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="id_art",nullable=false,unique=true,
	foreignKey=@ForeignKey(foreignKeyDefinition = 
	"foreign key(id_art) references articulo")) 
	private Articulo articulo;
	
	@ManyToOne
	@JoinColumn(name="id_prov",nullable=false,unique=true,
	foreignKey=@ForeignKey(foreignKeyDefinition = 
	"foreign key(id_prov) references proveedor")) 
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name="id_emp",nullable=false,unique=true,
	foreignKey=@ForeignKey(foreignKeyDefinition = 
	"foreign key(id_emp) references empleado")) 
	private Empleado empleado;

	public Compra(Integer id_compra, Date fech_comp, Double total, String estado, Articulo articulo,
			Proveedor proveedor, Empleado empleado) {
		super();
		this.id_compra = id_compra;
		this.fech_comp = fech_comp;
		this.total = total;
		this.estado = estado;
		this.articulo = articulo;
		this.proveedor = proveedor;
		this.empleado = empleado;
	}

	public Compra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId_compra() {
		return id_compra;
	}

	public void setId_compra(Integer id_compra) {
		this.id_compra = id_compra;
	}

	public Date getFech_comp() {
		return fech_comp;
	}

	public void setFech_comp(Date fech_comp) {
		this.fech_comp = fech_comp;
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

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
	
	
	
	
}
