package mx.com.burodecredito.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "ambientes")
@Data
public class Ambientes implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ambientes_generator")
    @SequenceGenerator(name="ambientes_generator", sequenceName = "ambientes_sequence", allocationSize = 1)
    @Column(insertable = false, name = "id_ambiente", nullable = false)
    private Integer idAmbiente;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_server")
    private Servers server;

    @NotNull
    @Column(name = "usuario")
    private String usuario;

    @NotNull
    @Column(name = "pass")
    private String pass;

    @NotNull
    @Column(name = "ruta")
    private String ruta;

    @NotNull
    @Column(name = "puerto")
    private Integer puerto;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_aplicativo")
    private Aplicativos aplicativo;

    
}