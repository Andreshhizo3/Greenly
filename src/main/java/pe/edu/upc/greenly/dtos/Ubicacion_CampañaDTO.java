package pe.edu.upc.greenly.dtos;

public class Ubicacion_CampañaDTO {
    private Long id;
    private String Departamento;
    private String Distrito;
    private String Direccion;

    public Ubicacion_CampañaDTO(Long id, String departamento, String distrito, String direccion) {
        this.id = id;
        Departamento = departamento;
        Distrito = distrito;
        Direccion = direccion;
    }

    public Ubicacion_CampañaDTO() {
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

    @Override
    public String toString() {
        return "Ubicacion_CampañaDTO{" +
                "id=" + id +
                ", Departamento='" + Departamento + '\'' +
                ", Distrito='" + Distrito + '\'' +
                ", Direccion='" + Direccion + '\'' +
                '}';
    }
}
