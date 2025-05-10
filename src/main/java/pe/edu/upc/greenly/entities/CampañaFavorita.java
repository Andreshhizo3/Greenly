package pe.edu.upc.greenly.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CampañaFavorita")
public class CampañaFavorita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCampañaFav;

    @ManyToOne
    @JoinColumn(name = "campaña_id_campaña")
    private Campaña campaña;

    @ManyToOne
    @JoinColumn(name = "donante_id_donante")
    private Donante donante;

    public CampañaFavorita() {
    }

    public CampañaFavorita(Long idCampañaFav, Campaña campaña, Donante donante) {
        this.idCampañaFav = idCampañaFav;
        this.campaña = campaña;
        this.donante = donante;
    }

    public Long getIdCampañaFav() {
        return idCampañaFav;
    }

    public void setIdCampañaFav(Long idCampañaFav) {
        this.idCampañaFav = idCampañaFav;
    }

    public Campaña getCampaña() {
        return campaña;
    }

    public void setCampaña(Campaña campaña) {
        this.campaña = campaña;
    }

    public Donante getDonante() {
        return donante;
    }

    public void setDonante(Donante donante) {
        this.donante = donante;
    }
}
