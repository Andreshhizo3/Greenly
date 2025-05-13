package pe.edu.upc.greenly.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "campaña")
public class Campaña {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    @ManyToOne
    @JoinColumn(name = "ong_id", referencedColumnName = "id")
    private Ong ong;

    @OneToOne
    @JoinColumn(name = "ubicacion_Campaña_id", referencedColumnName = "id")
    private Ubicacion_Campaña ubicacion_Campaña;
    @JsonIgnore
    @OneToMany(mappedBy = "campaña", fetch = FetchType.EAGER)
    private List<Donacion> donacion;

    @JsonIgnore
    @OneToMany(mappedBy = "campaña", fetch =FetchType.EAGER)
    private List<Post> post;


    public Campaña(Long id, String titulo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, Ong ong, Ubicacion_Campaña ubicacion_Campaña, List<Donacion> donacion, List<Post> post) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ong = ong;
        this.ubicacion_Campaña = ubicacion_Campaña;
        this.donacion = donacion;
        this.post = post;
    }

    public Campaña() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Ong getOng() {
        return ong;
    }

    public void setOng(Ong ong) {
        this.ong = ong;
    }

    public Ubicacion_Campaña getUbicacion_Campaña() {
        return ubicacion_Campaña;
    }

    public void setUbicacion_Campaña(Ubicacion_Campaña ubicacion_Campaña) {
        this.ubicacion_Campaña = ubicacion_Campaña;
    }

    public List<Donacion> getDonacion() {
        return donacion;
    }

    public void setDonacion(List<Donacion> donacion) {
        this.donacion = donacion;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Campaña{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", ong=" + ong +
                ", ubicacion_Campaña=" + ubicacion_Campaña +
                ", donacion=" + donacion +
                ", post=" + post +
                '}';
    }
}


