package pe.edu.upc.greenly.dtos;

public class RolDTO {

    private Long id;
    private String rol;
    private Long usuarioId;

    public RolDTO(Long id, String rol, Long usuarioId) {
        this.id = id;
        this.rol = rol;
        this.usuarioId = usuarioId;
    }

    public RolDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "RolDTO{" +
                "id=" + id +
                ", rol='" + rol + '\'' +
                ", usuarioId=" + usuarioId +
                '}';
    }
}