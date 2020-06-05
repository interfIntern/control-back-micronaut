package mx.com.burodecredito.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Table(name = "ambientes_versiones")
@Entity
@Data
public class AmbientesVersiones implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ambientes_versiones_generator")
    @SequenceGenerator(name="ambientes_versiones_generator", sequenceName = "ambientes_versiones_sequence", allocationSize = 1)
    @Column(insertable = false, name = "id_ambiente_version", nullable = false)
    private Integer idAmbienteVersion;

    @NotNull
    @Column(name = "id_ambiente")
    private Integer idAmbiente;

    @NotNull
    @Column(name = "id_version")
    private Integer idVersion;

    @NotNull
    @Column(name = "desde")
    private String desde;

    @Column(name = "hasta")
    private String hasta;

    
}