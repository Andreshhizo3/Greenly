package pe.edu.upc.greenly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.greenly.entities.EstadoDonacion;

import java.util.List;

public interface EstadoDonacionRepository extends JpaRepository<EstadoDonacion, Long> {
    //Query Method 1
    List<EstadoDonacion> findByEstado(String estado);
}
