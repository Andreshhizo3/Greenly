package pe.edu.upc.greenly.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "donante")
public class Donante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nombre;
    private String dni;
    private String correo;
    private String telefono;
    private String direccion;
    private LocalDate fechaNacimiento;

    //Relacion uno a uno con usuario
    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;
    @JsonIgnore
    @OneToMany (mappedBy = "donante",fetch = FetchType.EAGER)
    private List<Donacion> donaciones;

    @JsonIgnore
    @OneToMany (mappedBy = "donante",fetch = FetchType.EAGER)
    private List<Comentario> comentarios;

    @JsonIgnore
    @OneToMany (mappedBy = "donante",fetch = FetchType.EAGER)
    private List<CampañaFavorita> campañaFavoritas;


    public Donante(Long id, String nombre, String dni, String correo, String telefono, String direccion, LocalDate fechaNacimiento, Usuario usuario, List<Donacion> donaciones, List<Comentario> comentarios, List<CampañaFavorita> campañaFavoritas) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.donaciones = donaciones;
        this.comentarios = comentarios;
        this.campañaFavoritas = campañaFavoritas;
    }

    public Donante() {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Donacion> getDonaciones() {
        return donaciones;
    }

    public void setDonaciones(List<Donacion> donaciones) {
        this.donaciones = donaciones;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<CampañaFavorita> getCampañaFavoritas() {
        return campañaFavoritas;
    }

    public void setCampañaFavoritas(List<CampañaFavorita> campañaFavoritas) {
        this.campañaFavoritas = campañaFavoritas;
    }

    @Override
    public String toString() {
        return "Donante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", usuario=" + usuario +
                ", donaciones=" + donaciones +
                ", comentarios=" + comentarios +
                ", campañaFavoritas=" + campañaFavoritas +
                '}';
    }
}
