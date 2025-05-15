package pe.edu.upc.greenly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.greenly.entities.Donacion;

import java.util.List;

public interface DonacionRepository extends JpaRepository<Donacion, Long> {
    //2. SQL QUERY TOTAL DE DONACIONES POR CAMPAÑA
    @Query(value = "SELECT c.id AS campañaId, c.titulo AS nombreCampaña, SUM(d.monto_donado) AS total " +
            "FROM donaciones d " +
            "JOIN campaña c ON d.campaña_id = c.id " +
            "GROUP BY c.id, c.titulo",
            nativeQuery = true)
    List<Object[]> findTotalesPorCampaña();
}
