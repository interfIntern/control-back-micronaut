package mx.com.burodecredito.domain;

import io.micronaut.http.annotation.Post;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "folios")
@Data
public class Folios implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "folios_generator")
    @SequenceGenerator(name="folios_generator", sequenceName = "folios_sequence", allocationSize = 1)
    @Column(name = "id_folio", insertable = false, nullable = false)
    private Integer idFolio;

    @NotNull
    @Column(name = "folio_cq")
    private String folioCq;

    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "resumen")
    private String resumen;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_lider")
    private Lideres lider;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_aplicativo")
    private Aplicativos aplicativo;
}