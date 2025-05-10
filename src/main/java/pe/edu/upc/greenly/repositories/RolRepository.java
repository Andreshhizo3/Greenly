package pe.edu.upc.greenly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.greenly.entities.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
}