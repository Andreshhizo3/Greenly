package pe.edu.upc.greenly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.greenly.entities.TipoDonacion;

import java.util.List;

public interface TipoDonacionRepository extends JpaRepository<TipoDonacion, Long> {
    //Query Method 2
    List<TipoDonacion> findByNombre(String nombre);
}
