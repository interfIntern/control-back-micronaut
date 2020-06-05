package mx.com.burodecredito.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Table(name = "aplicativos")
@Entity
@Data
public class Aplicativos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aplicativos_generator")
    @SequenceGenerator(name="aplicativos_generator", sequenceName = "aplicativos_sequence", allocationSize = 1)
    @Column(name = "id_aplicativo", insertable = false, nullable = false)
    private Integer idAplicativo;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "resumen")
    private String resumen;

    @NotNull
    @Column(name = "id_suite")
    private Integer idSuite;

    
}