package pe.edu.upc.greenly.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "donaciones")
public class Donacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String descripcion;
    private Double montoDonado;
    private String metodoEntrega;
    private LocalDate fechaDonacion;

    @ManyToOne
    @JoinColumn(name = "donante_id")
    private Donante donante;

    @ManyToOne
    @JoinColumn(name = "campaña_id")
    private Campaña campaña;

    @ManyToOne
    @JoinColumn(name = "tipo_donacion_id")
    private TipoDonacion tipoDonacion;

    @ManyToOne
    @JoinColumn(name = "estado_donacion_id")
    private EstadoDonacion estadoDonacion;

    public Donacion(Long id, String name, String descripcion, Double montoDonado, String metodoEntrega, LocalDate fechaDonacion, Donante donante, Campaña campaña, TipoDonacion tipoDonacion, EstadoDonacion estadoDonacion) {
        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
        this.montoDonado = montoDonado;
        this.metodoEntrega = metodoEntrega;
        this.fechaDonacion = fechaDonacion;
        this.donante = donante;
        this.campaña = campaña;
        this.tipoDonacion = tipoDonacion;
        this.estadoDonacion = estadoDonacion;
    }

    public Donacion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getMontoDonado() {
        return montoDonado;
    }

    public void setMontoDonado(Double montoDonado) {
        this.montoDonado = montoDonado;
    }

    public String getMetodoEntrega() {
        return metodoEntrega;
    }

    public void setMetodoEntrega(String metodoEntrega) {
        this.metodoEntrega = metodoEntrega;
    }

    public LocalDate getFechaDonacion() {
        return fechaDonacion;
    }

    public void setFechaDonacion(LocalDate fechaDonacion) {
        this.fechaDonacion = fechaDonacion;
    }

    public Donante getDonante() {
        return donante;
    }

    public void setDonante(Donante donante) {
        this.donante = donante;
    }

    public Campaña getCampaña() {
        return campaña;
    }

    public void setCampaña(Campaña campaña) {
        this.campaña = campaña;
    }

    public TipoDonacion getTipoDonacion() {
        return tipoDonacion;
    }

    public void setTipoDonacion(TipoDonacion tipoDonacion) {
        this.tipoDonacion = tipoDonacion;
    }

    public EstadoDonacion getEstadoDonacion() {
        return estadoDonacion;
    }

    public void setEstadoDonacion(EstadoDonacion estadoDonacion) {
        this.estadoDonacion = estadoDonacion;
    }

    @Override
    public String toString() {
        return "Donacion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", montoDonado=" + montoDonado +
                ", metodoEntrega='" + metodoEntrega + '\'' +
                ", fechaDonacion=" + fechaDonacion +
                ", donante=" + donante +
                ", campaña=" + campaña +
                ", tipoDonacion=" + tipoDonacion +
                ", estadoDonacion=" + estadoDonacion +
                '}';
    }
}
