package pe.edu.upc.greenly.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "estadoDonaciones")
public class EstadoDonacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String estado;
    private LocalDate fecha;

    @JsonIgnore
    @OneToMany(mappedBy = "estadoDonacion", fetch = FetchType.EAGER)
    private List<Donacion> donaciones;

    public EstadoDonacion() {}
    public EstadoDonacion(Long id, String estado, LocalDate fecha, List<Donacion> donaciones) {
        this.id = id;
        this.estado = estado;
        this.fecha = fecha;
        this.donaciones = donaciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Donacion> getDonaciones() {
        return donaciones;
    }

    public void setDonaciones(List<Donacion> donaciones) {
        this.donaciones = donaciones;
    }
}
