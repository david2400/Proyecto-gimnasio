package co.com.springboot.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the clase database table.
 * 
 */

@Entity
@Data
@Table(name="clase",schema="gimnasio")
@NamedQuery(name="Clase.findAll", query="SELECT c FROM Clase c")
public class Clase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idClase;

	private String descripcion;
	
	@NotNull(message = "{error.campoObligatorio}")
	private String dias;
	
	@NotNull(message = "{error.campoObligatorio}")
	@Temporal(TemporalType.DATE)
	private Date horaFin;
	
	@NotNull(message = "{error.campoObligatorio}")
	@Temporal(TemporalType.DATE)
	private Date horaInicio;
	
	@NotNull(message = "{error.campoObligatorio}")
	@NotBlank(message="El nombre de la clase es obligatoria")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="idSala")
	private Sala sala;

	//bi-directional many-to-one association to InstructorClase
	@OneToMany(mappedBy="clase")
	private List<InstructorClase> instructorClases;

	//bi-directional many-to-one association to SocioClase
	@OneToMany(mappedBy="clase")
	private List<SocioClase> socioClases;

	public Clase() {
		super();
	}



}