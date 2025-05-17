package pe.edu.upc.greenly.dtos;

import java.time.LocalDate;

//1. JPQL  TODOS LOS COMENTARIOS POR CAMPAÑA
public class ComentarioCampañaDTO {
    private Long idComentario;
    private String contenido;
    private LocalDate fechaComentario;
    private String nombreCampaña;

    public ComentarioCampañaDTO(Long idComentario, String contenido, LocalDate fechaComentario, String nombreCampaña) {
        this.idComentario = idComentario;
        this.contenido = contenido;
        this.fechaComentario = fechaComentario;
        this.nombreCampaña = nombreCampaña;
    }

    public ComentarioCampañaDTO() {
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

    public String getNombreCampaña() {
        return nombreCampaña;
    }

    public void setNombreCampaña(String nombreCampaña) {
        this.nombreCampaña = nombreCampaña;
    }
}
