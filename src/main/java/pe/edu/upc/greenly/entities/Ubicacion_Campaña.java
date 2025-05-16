package pe.edu.upc.greenly.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="Ubicacion_Campaña")
public class Ubicacion_Campaña {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Departamento;
    private String Distrito;
    private String Direccion;

    @JsonIgnore
    @OneToOne(mappedBy = "ubicacion_Campaña")
    private Campaña campaña;

    public Ubicacion_Campaña(Long id, String departamento, String distrito, String direccion, Campaña campaña) {
        this.id = id;
        Departamento = departamento;
        Distrito = distrito;
        Direccion = direccion;
        this.campaña = campaña;
    }

    public Ubicacion_Campaña() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String departamento) {
        Departamento = departamento;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String distrito) {
        Distrito = distrito;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public Campaña getCampaña() {
        return campaña;
    }

    public void setCampaña(Campaña campaña) {
        this.campaña = campaña;
    }
}
