package pe.edu.upc.greenly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.greenly.entities.Campaña;

public interface CampañaRepository extends JpaRepository<Campaña,Long> {
}
