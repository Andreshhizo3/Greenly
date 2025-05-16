package pe.edu.upc.greenly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.greenly.dtos.ComentarioCampañaDTO;
import pe.edu.upc.greenly.entities.Comentario;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    //2. JPQL  TODOS LOS COMENTARIOS POR CAMPAÑA
    @Query("SELECT new pe.edu.upc.greenly.dtos.ComentarioCampañaDTO(" +
            "c.idComentario, c.contenido, c.fechaComentario, c.post.campaña.titulo) " +
            "FROM Comentario c " +
            "WHERE c.post.campaña.id = :campañaId")
    List<ComentarioCampañaDTO> findComentariosPorCampaña(@Param("campañaId") Long campañaId);
}
