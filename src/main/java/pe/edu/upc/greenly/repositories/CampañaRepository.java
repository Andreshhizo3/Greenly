package pe.edu.upc.greenly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.greenly.entities.Campaña;

import java.util.List;

public interface CampañaRepository extends JpaRepository<Campaña,Long> {
    // 1. Query Method Obtener campañas por ONG ingresado
    List<Campaña> findByOngId(Long ongId);
}
