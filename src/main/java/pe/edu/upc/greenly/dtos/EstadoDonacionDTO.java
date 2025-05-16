package pe.edu.upc.greenly.dtos;

import java.time.LocalDate;

public class EstadoDonacionDTO {

    private Long id;
    private String estado;
    private LocalDate fecha;

    public EstadoDonacionDTO() {}

    public EstadoDonacionDTO(Long id, String estado, LocalDate fecha) {
        this.id = id;
        this.estado = estado;
        this.fecha = fecha;
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
}
