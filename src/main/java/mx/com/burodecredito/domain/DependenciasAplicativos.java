package mx.com.burodecredito.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "dependencias_aplicativos")
public class DependenciasAplicativos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dependencias_aplicativos_generator")
    @SequenceGenerator(name="dependencias_aplicativos_generator", sequenceName = "dependencias_aplicativos_sequence", allocationSize = 1)
    @Column(name = "id_dependencia", insertable = false, nullable = false)
    private Integer idDependencia;

    @NotNull
    @Column(name = "id_aplicativo")
    private Integer idAplicativo;

    @NotNull
    @Column(name = "dependencia")
    private Integer dependencia;

    
}