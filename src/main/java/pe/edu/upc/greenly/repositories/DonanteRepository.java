package pe.edu.upc.greenly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.greenly.entities.Donante;

import java.time.LocalDate;
import java.util.List;

public interface DonanteRepository extends JpaRepository<Donante, Long> {
    //JPQL Donante de una campaña específica
    @Query("SELECT d FROM Donacion dn JOIN dn.donante d WHERE dn.campaña.id = ?1")
    List<Donante> findDonantesByCampañaId(Long campañaId);

    //JPQL Donantes con mas de X donaciones
    @Query("SELECT d FROM Donante d WHERE SIZE(d.donaciones) > ?1")
    List<Donante> findDonantesConMasDeXDonaciones(int cantidadMinima);





}
