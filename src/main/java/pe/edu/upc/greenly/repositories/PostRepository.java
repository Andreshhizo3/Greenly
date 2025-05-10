package pe.edu.upc.greenly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.greenly.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
