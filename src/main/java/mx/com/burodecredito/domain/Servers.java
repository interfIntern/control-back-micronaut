package mx.com.burodecredito.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Table(name = "servers")
@Entity
@Data
public class Servers implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servers_generator")
    @SequenceGenerator(name="servers_generator", sequenceName = "servers_sequence", allocationSize = 1)
    @Column(insertable = false, name = "id_server", nullable = false)
    private Integer idServer;

    @NotNull
    @Column(name = "procesador")
    private String procesador;

    @NotNull
    @Column(name = "volumen_disco")
    private Integer volumenDisco;

    @NotNull
    @Column(name = "ram")
    private Integer ram;

    @NotNull
    @Column(name = "so")
    private String so;

    @NotNull
    @Column(name = "ip")
    private String ip;

    
}