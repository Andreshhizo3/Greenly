package pe.edu.upc.greenly.dtos;

public class OngDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String correo;
    private String direccion;
    private String telefono;
    private Long usuarioId; //Solo el ID del usuario relacionado

    public OngDTO(Long id, String nombre, String descripcion, String correo, String direccion, String telefono, Long usuarioId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.usuarioId = usuarioId;
    }

    public OngDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "OngDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", usuarioId=" + usuarioId +
                '}';
    }
}
