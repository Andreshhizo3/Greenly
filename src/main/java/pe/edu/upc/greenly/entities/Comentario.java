package pe.edu.upc.greenly.entities;

import jakarta.persistence.*;
        import java.util.Date;

@Entity
@Table(name = "Comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentario;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contenido;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_comentario")
    private Date fechaComentario;

    @ManyToOne
    @JoinColumn(name = "posts_id_posts")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "donante_id_donante")
    private Donante donante;

    public Comentario() {
    }

    public Comentario(int idComentario, String contenido, Date fechaComentario, Post post, Donante donante) {
        this.idComentario = idComentario;
        this.contenido = contenido;
        this.fechaComentario = fechaComentario;
        this.post = post;
        this.donante = donante;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
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
