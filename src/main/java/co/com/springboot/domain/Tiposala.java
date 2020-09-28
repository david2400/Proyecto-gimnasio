package co.com.springboot.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.List;


/**
 * The persistent class for the tiposala database table.
 * 
 */
@Entity
@Data
@Table(name="tipoSala",schema="gimnasio")
@NamedQuery(name="Tiposala.findAll", query="SELECT t FROM Tiposala t")
public class Tiposala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipoSala;

	private String nombre;

	//bi-directional many-to-one association to Sala
	@OneToMany(mappedBy="tiposala")
	private List<Sala> salas;

	

}