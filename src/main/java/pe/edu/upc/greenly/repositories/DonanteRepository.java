package pe.edu.upc.greenly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.greenly.entities.Donante;

import java.util.List;

public interface DonanteRepository extends JpaRepository<Donante, Long> {
    List<Object[]> obtenerUltimaDonacionPorDonante();
}
