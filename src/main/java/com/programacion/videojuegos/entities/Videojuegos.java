package com.programacion.videojuegos.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name="videojuegos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Videojuegos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "{NotEmpty.Videojuegos.titulo}")
    private String titulo;
    @Size(min=5, max=500, message = "{Size.Videojuegos.descripcion}")
    private String descripcion;
    private String imagen;

    @Min(value = 5, message = "{Min.Videojuegos.precio}")
    @Max(value = 10000, message = "{Max.Videojuegos.precio}")
    private long precio;

    @Min(value = 1, message = "{Min.Videojuegos.stock}")
    @Max(value = 10000, message = "{Max.Videojuegos.stock}")
    private short stock;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{NotNull.Videojuegos.fecha}")
    @PastOrPresent(message = "{PastOrPresent.Videojuegos.fecha}")
    private Date fechaDeLanzamiento;
    private boolean activo = true;

    @NotNull(message = "{NotNull.Videojuegos.estudio}")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "fk_estudio", nullable = false)
    private Estudio estudio;

    @NotNull(message = "{NotNull.Videojuegos.categoria}")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_categoria", nullable = false)
    private Categoria categoria;

}
