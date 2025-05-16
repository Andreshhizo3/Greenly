package pe.edu.upc.greenly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.greenly.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}