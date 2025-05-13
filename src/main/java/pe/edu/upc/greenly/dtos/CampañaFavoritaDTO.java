package pe.edu.upc.greenly.dtos;

public class CampañaFavoritaDTO {
    private Long idCampañaFav;
    private Long campañaId;
    private Long donanteId;

    public CampañaFavoritaDTO(Long idCampañaFav, Long campañaId, Long donanteId) {
        this.idCampañaFav = idCampañaFav;
        this.campañaId = campañaId;
        this.donanteId = donanteId;
    }

    public CampañaFavoritaDTO() {
    }

    public Long getIdCampañaFav() {
        return idCampañaFav;
    }

    public void setIdCampañaFav(Long idCampañaFav) {
        this.idCampañaFav = idCampañaFav;
    }

    public Long getCampañaId() {
        return campañaId;
    }

    public void setCampañaId(Long campañaId) {
        this.campañaId = campañaId;
    }

    public Long getDonanteId() {
        return donanteId;
    }

    public void setDonanteId(Long donanteId) {
        this.donanteId = donanteId;
    }
}

