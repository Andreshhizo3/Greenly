package pe.edu.upc.greenly.dtos;

import java.time.LocalDate;
import java.util.Date;

public class ComentarioDTO {
    private Long idComentario;
    private String contenido;
    private LocalDate fechaComentario;
    private Long postId;
    private Long donanteId;

    public ComentarioDTO(Long idComentario, String contenido, LocalDate fechaComentario, Long postId, Long donanteId) {
        this.idComentario = idComentario;
        this.contenido = contenido;
        this.fechaComentario = fechaComentario;
        this.postId = postId;
        this.donanteId = donanteId;
    }

    public ComentarioDTO() {
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

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getDonanteId() {
        return donanteId;
    }

    public void setDonanteId(Long donanteId) {
        this.donanteId = donanteId;
    }
}
