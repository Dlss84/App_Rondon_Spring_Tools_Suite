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
@Table(name="cita")
public class Cita {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_cita;
	private Date fecha;
	private String observacion;
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="id_emp",nullable=false,unique=true,
	foreignKey=@ForeignKey(foreignKeyDefinition = 
	"foreign key(id_emp) references empleado")) 
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name="id_mas",nullable=false,unique=true,
	foreignKey=@ForeignKey(foreignKeyDefinition = 
	"foreign key(id_mas) references mascota")) 
	private Mascota mascota;

	public Cita(Integer id_cita, Date fecha, String observacion, String estado, Empleado empleado,
			Mascota mascota) {
		super();
		this.id_cita = id_cita;
		this.fecha = fecha;
		this.observacion = observacion;
		this.estado = estado;
		this.empleado = empleado;
		this.mascota = mascota;
	}

	public Cita() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId_cita() {
		return id_cita;
	}

	public void setId_cita(Integer id_cita) {
		this.id_cita = id_cita;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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


	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	
	
	
}
