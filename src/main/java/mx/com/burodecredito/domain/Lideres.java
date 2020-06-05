package mx.com.burodecredito.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "lideres")
@Data
public class Lideres implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lideres_generator")
    @SequenceGenerator(name="lideres_generator", sequenceName = "lideres_sequence", allocationSize = 1)
    @Column(name = "id_lider", insertable = false, nullable = false)
    private Integer idLider;

    @NotNull
    @Column(name = "primer_nombre")
    private String primerNombre;

    @Column(name = "segundo_nombre")
    private String segundoNombre;

    @NotNull
    @Column(name = "paterno")
    private String paterno;

    @NotNull
    @Column(name = "materno")
    private String materno;

    @NotNull
    @Column(name = "mail")
    private String mail;

    @NotNull
    @Column(name = "activo")
    private Boolean activo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "ext")
    private String ext;

    @NotNull
    @Column(name = "celular")
    private String celular;

    
}