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
@Table(name="articulo")
public class Articulo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_art;
	
	private String nombre;
	private Double pre_com;
	private Double pre_vent;
	private Integer stock;
	private Date fvenc;
	private String image;
	private String estado;
	@ManyToOne
	@JoinColumn(name="id_prov",nullable=false,unique=true,
	foreignKey=@ForeignKey(foreignKeyDefinition = 
	"foreign key(id_prov) references proveedor")) 
	private Proveedor proveedor;
	
	
	
	public Integer getId_art() {
		return id_art;
	}
	public void setId_art(Integer id_art) {
		this.id_art = id_art;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPre_com() {
		return pre_com;
	}
	public void setPre_com(Double pre_com) {
		this.pre_com = pre_com;
	}
	public Double getPre_vent() {
		return pre_vent;
	}
	public void setPre_vent(Double pre_vent) {
		this.pre_vent = pre_vent;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Date getFvenc() {
		return fvenc;
	}
	public void setFvenc(Date fvenc) {
		this.fvenc = fvenc;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Articulo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Articulo(Integer id_art, String nombre, Double pre_com, Double pre_vent, Integer stock, Date fvenc,
			String image, String estado, Proveedor proveedor) {
		super();
		this.id_art = id_art;
		this.nombre = nombre;
		this.pre_com = pre_com;
		this.pre_vent = pre_vent;
		this.stock = stock;
		this.fvenc = fvenc;
		this.image = image;
		this.estado = estado;
		this.proveedor = proveedor;
	}
	
	
	
	

}
