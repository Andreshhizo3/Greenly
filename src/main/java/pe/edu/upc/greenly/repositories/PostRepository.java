package pe.edu.upc.greenly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.greenly.entities.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    //Query Method (Spring Data JPA)
    List<Post> findByCampañaIdOrderByFechaPublicacionDesc(Long campañaId);
}
