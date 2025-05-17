package pe.edu.upc.greenly.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tipoDonaciones")
public class TipoDonacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoDonacion", fetch = FetchType.EAGER)
    private List<Donacion> donaciones;

    public TipoDonacion() {}

    public TipoDonacion(Long id, String nombre, List<Donacion> donaciones) {
        this.id = id;
        this.nombre = nombre;
        this.donaciones = donaciones;
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

    public List<Donacion> getDonaciones() {
        return donaciones;
    }

    public void setDonaciones(List<Donacion> donaciones) {
        this.donaciones = donaciones;
    }
}
