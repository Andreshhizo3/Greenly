package pe.edu.upc.greenly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.greenly.entities.Campaña;

import java.util.List;

public interface CampañaRepository extends JpaRepository<Campaña,Long> {
    // 1. Query Method Obtener campañas por ONG ingresado
    List<Campaña> findByOngId(Long ongId);

    //Campaña sin donaciones registradas
    @Query(value = "SELECT * FROM campana c LEFT JOIN donacion d ON c.id = d.campana_id WHERE d.id IS NULL", nativeQuery = true)
    List<Campaña> obtenerCampanasSinDonaciones();

}
