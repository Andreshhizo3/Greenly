package pe.edu.upc.greenly.dtos;
//1. SQL QUERY TOTAL DE DONACIONES POR CAMPAÑA
public class TotalDonacionesPorCampañaDTO {
    private Long campañaId;
    private String nombreCampaña;
    private Double total;

    public TotalDonacionesPorCampañaDTO(Long campañaId, String nombreCampaña, Double total) {
        this.campañaId = campañaId;
        this.nombreCampaña = nombreCampaña;
        this.total = total;
    }

    public TotalDonacionesPorCampañaDTO() {
    }

    public Long getCampañaId() {
        return campañaId;
    }

    public void setCampañaId(Long campañaId) {
        this.campañaId = campañaId;
    }

    public String getNombreCampaña() {
        return nombreCampaña;
    }

    public void setNombreCampaña(String nombreCampaña) {
        this.nombreCampaña = nombreCampaña;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}

