package pe.edu.upc.greenly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.greenly.entities.CampañaFavorita;

public interface CampañaFavoritaRepository extends JpaRepository<CampañaFavorita, Long> {

import java.util.List;
@Repository
public interface CampañaFavoritaRepository extends JpaRepository<CampañaFavorita, Long> {
    Lis<CampañaFavorita> findByDonante_Id(Long donanteId);

}
