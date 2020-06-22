package mx.com.burodecredito.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Table(name = "versiones")
@Entity
public class Versiones implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "versiones_generator")
    @SequenceGenerator(name="versiones_generator", sequenceName = "versiones_sequence", allocationSize = 1)
    @Column(name = "id_version", insertable = false, nullable = false)
    private Integer idVersion;

    @NotNull
    @Column(name = "version")
    private String version;

    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "resumen")
    private String resumen;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_aplicativo")
    private Aplicativos aplicativo;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_folio")
    private Folios folio;

    
}