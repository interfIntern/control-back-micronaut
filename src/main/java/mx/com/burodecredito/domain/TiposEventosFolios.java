package mx.com.burodecredito.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "tipos_eventos_folios")
@Data
public class TiposEventosFolios implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipos_eventos_folios_generator")
    @SequenceGenerator(name="tipos_eventos_folios_generator", sequenceName = "tipos_eventos_folios_sequence", allocationSize = 1)
    @Column(name = "id_tipo_evento", insertable = false, updatable = false, nullable = false)
    private Integer idTipoEvento;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    
}