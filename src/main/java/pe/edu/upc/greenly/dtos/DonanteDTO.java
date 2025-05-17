package pe.edu.upc.greenly.dtos;

import java.time.LocalDate;

public class DonanteDTO {
    private Long id;
    private String nombre;
    private String dni;
    private String correo;
    private String telefono;
    private String direccion;
    private LocalDate fechaNacimiento;
    private Long usuarioId;


    public DonanteDTO(Long id, String nombre, String dni, String correo, String telefono, String direccion, LocalDate fechaNacimiento, Long usuarioId) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.usuarioId = usuarioId;
    }

    public DonanteDTO() {
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "DonanteDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dni=" + dni +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", usuarioId=" + usuarioId +
                '}';
    }
}
