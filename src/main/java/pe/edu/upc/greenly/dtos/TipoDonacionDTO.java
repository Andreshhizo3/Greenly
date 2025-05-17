package pe.edu.upc.greenly.dtos;

public class TipoDonacionDTO {
    private Long id;
    private String nombre;

    public TipoDonacionDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TipoDonacionDTO() {
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

    @Override
    public String toString() {
        return "TipoDonacionDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}