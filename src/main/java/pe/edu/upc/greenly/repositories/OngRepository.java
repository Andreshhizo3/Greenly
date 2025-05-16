package pe.edu.upc.greenly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.greenly.entities.Ong;

import java.util.List;

public interface OngRepository extends JpaRepository<Ong, Long> {
    //SQL Campañas por año específico
    @Query(value = "SELECT DISTINCT o.* FROM ong o " +
            "JOIN campaña c ON o.id = c.ong_id " +
            "WHERE YEAR(c.fecha_inicio) = ?1", nativeQuery = true)
    List<Ong> findOngsConCampañasEnAnio(int anio);
}
