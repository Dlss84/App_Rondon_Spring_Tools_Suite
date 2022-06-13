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
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_usuario;
	private String nombre;	
	private String apellido;	
	private Integer nun_doc;	
	private String telefono;	
	private String nom_user;	
	private String pass;	
	private String direccion;	
	private String correo;
	
	@ManyToOne
	@JoinColumn(name="id_tip_user",nullable=false,unique=true,
	foreignKey=@ForeignKey(foreignKeyDefinition = 
	"foreign key(id_tip_user) references tipo_usuario"))
	private Tip_Usuario tip_usuario;
	
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
	
	@Override
	public String toString() {
		return "User{" + "id_usuario=" + id_usuario + ", nom_user='" + nom_user + 
				'\'' + ", pass='" + pass + '\''
				+ '}';
	}

	

	public Usuario(Integer id_usuario, String nombre, String apellido, Integer nun_doc, String telefono,
			String nom_user, String pass, String direccion, String correo, Tip_Usuario tip_usuario, Tip_Doc tip_doc,
			Distrito distrito) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nun_doc = nun_doc;
		this.telefono = telefono;
		this.nom_user = nom_user;
		this.pass = pass;
		this.direccion = direccion;
		this.correo = correo;
		this.tip_usuario = tip_usuario;
		this.tip_doc = tip_doc;
		this.distrito = distrito;
	}

	public Usuario(Integer id_usuario, String nombre, String apellido, Integer nun_doc, String telefono,
			String nom_user, String pass, String direccion, String correo, Tip_Doc tip_doc, Distrito distrito) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nun_doc = nun_doc;
		this.telefono = telefono;
		this.nom_user = nom_user;
		this.pass = pass;
		this.direccion = direccion;
		this.correo = correo;
		this.tip_doc = tip_doc;
		this.distrito = distrito;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getNun_doc() {
		return nun_doc;
	}

	public void setNun_doc(Integer nun_doc) {
		this.nun_doc = nun_doc;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNom_user() {
		return nom_user;
	}

	public void setNom_user(String nom_user) {
		this.nom_user = nom_user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
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

	public Tip_Usuario getTip_usuario() {
		return tip_usuario;
	}

	public void setTip_usuario(Tip_Usuario tip_usuario) {
		this.tip_usuario = tip_usuario;
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
