package pe.edu.upc.greenly.dtos;

public class CampañaFavoritaDTO {
    private Long idCampañaFav;
    private int campañaId;
    private int donanteId;

    public Long getIdCampañaFav() {
        return idCampañaFav;
    }

    public void setIdCampañaFav(Long idCampañaFav) {
        this.idCampañaFav = idCampañaFav;
    }

    public int getCampañaId() {
        return campañaId;
    }

    public void setCampañaId(int campañaId) {
        this.campañaId = campañaId;
    }

    public int getDonanteId() {
        return donanteId;
    }

    public void setDonanteId(int donanteId) {
        this.donanteId = donanteId;
    }
}
