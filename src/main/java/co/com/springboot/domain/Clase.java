package co.com.springboot.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the clase database table.
 * 
 */

@Entity
@Data

@NamedQuery(name="Clase.findAll", query="SELECT c FROM Clase c")
public class Clase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idClase;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Temporal(TemporalType.DATE)
	private Date horaFin;

	@Temporal(TemporalType.DATE)
	private Date horaInicio;

	private int idInstructor;

	private String nombre;

	@Column(name="sala_idsala")
	private int salaIdsala;

	//bi-directional many-to-one association to ClaseSala
	@OneToMany(mappedBy="clase")
	private List<ClaseSala> claseSalas;

	//bi-directional many-to-one association to InstructorClase
	@OneToMany(mappedBy="clase")
	private List<InstructorClase> instructorClases;

	//bi-directional many-to-one association to SocioClase
	@OneToMany(mappedBy="clase")
	private List<SocioClase> socioClases;



}