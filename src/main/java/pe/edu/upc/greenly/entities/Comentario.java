package pe.edu.upc.greenly.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentario;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contenido;

    //@Temporal(TemporalType.DATE)
    @Column(name = "fecha_comentario")
    private LocalDate fechaComentario;

    @ManyToOne
    @JoinColumn(name = "posts_id_posts")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "donante_id_donante")
    private Donante donante;

    public Comentario() {
    }

    public Comentario(Long idComentario, String contenido, LocalDate fechaComentario, Post post, Donante donante) {
        this.idComentario = idComentario;
        this.contenido = contenido;
        this.fechaComentario = fechaComentario;
        this.post = post;
        this.donante = donante;
    }

    public Long getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Long idComentario) {
        this.idComentario = idComentario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(LocalDate fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Donante getDonante() {
        return donante;
    }

    public void setDonante(Donante donante) {
        this.donante = donante;
    }
}
