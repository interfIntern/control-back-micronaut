package mx.com.burodecredito.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Table(name = "suites")
@Data
@Entity
public class Suites implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "suites_generator")
    @SequenceGenerator(name="suites_generator", sequenceName = "suites_sequence", allocationSize = 1)
    @Column(name = "id_suite", insertable = false, nullable = false)
    private Integer idSuite;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    
}