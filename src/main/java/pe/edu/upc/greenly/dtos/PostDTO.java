package pe.edu.upc.greenly.dtos;

import java.util.Arrays;
import java.util.Date;

public class PostDTO {
    private Long idPosts;
    private String contenido;
    private byte[] imagen;
    private Date fechaPublicacion;
    private Long campañaId;

    public PostDTO(Long idPosts, String contenido, byte[] imagen, Date fechaPublicacion, Long campañaId) {
        this.idPosts = idPosts;
        this.contenido = contenido;
        this.imagen = imagen;
        this.fechaPublicacion = fechaPublicacion;
        this.campañaId = campañaId;
    }

    public PostDTO() {
    }
    /*private Long donanteId;*/

    public Long getIdPosts() {
        return idPosts;
    }

    public void setIdPosts(Long idPosts) {
        this.idPosts = idPosts;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Long getCampañaId() {
        return campañaId;
    }

    public void setCampañaId(Long campañaId) {
        this.campañaId = campañaId;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "idPosts=" + idPosts +
                ", contenido='" + contenido + '\'' +
                ", imagen=" + Arrays.toString(imagen) +
                ", fechaPublicacion=" + fechaPublicacion +
                ", campañaId=" + campañaId +
                '}';
    }
}
