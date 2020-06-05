package mx.com.burodecredito.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Table(name = "eventos_folios")
@Entity
@Data
public class EventosFolios implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eventos_folios_generator")
    @SequenceGenerator(name="eventos_folios_generator", sequenceName = "eventos_folios_sequence", allocationSize = 1)
    @Column(insertable = false, name = "id_evento", nullable = false)
    private Integer idEvento;

    @NotNull
    @Column(name = "id_tipo_evento")
    private Integer idTipoEvento;

    @NotNull
    @Column(name = "registrado_en")
    private String registradoEn;

    @Column(name = "fecha_hora")
    private String fechaHora;

    @NotNull
    @Column(name = "id_lider")
    private Integer idLider;

    @NotNull
    @Column(name = "id_folio")
    private Integer idFolio;

    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    
}