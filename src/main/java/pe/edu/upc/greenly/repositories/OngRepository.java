package pe.edu.upc.greenly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.greenly.entities.Ong;

public interface OngRepository extends JpaRepository<Ong, Long> {
}
