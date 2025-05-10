package pe.edu.upc.greenly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.greenly.entities.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
