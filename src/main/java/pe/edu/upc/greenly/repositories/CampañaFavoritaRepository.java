package pe.edu.upc.greenly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.greenly.entities.CampañaFavorita;

public interface CampañaFavoritaRepository extends JpaRepository<CampañaFavorita, Long> {
}
