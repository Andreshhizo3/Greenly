package pe.edu.upc.greenly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.greenly.dtos.DonacionDTO;
import pe.edu.upc.greenly.entities.Donacion;

import java.util.List;

public interface DonacionRepository extends JpaRepository<Donacion, Long> {

    @Query("SELECT new pe.edu.upc.greenly.dtos.DonacionDTO(" +
            "d.id, d.name, d.descripcion, d.montoDonado, d.metodoEntrega, d.fechaDonacion, " +
            "d.donante.id, d.campaña.id, d.tipoDonacion.id, d.estadoDonacion.id) " +
            "FROM Donacion d ORDER BY d.fechaDonacion ASC")
    List<DonacionDTO> donacionesMasAntiguas();

    @Query("SELECT new pe.edu.upc.greenly.dtos.DonacionDTO(" +
            "d.id, d.name, d.descripcion, d.montoDonado, d.metodoEntrega, d.fechaDonacion, " +
            "d.donante.id, d.campaña.id, d.tipoDonacion.id, d.estadoDonacion.id) " +
            "FROM Donacion d ORDER BY d.fechaDonacion DESC")
    List<DonacionDTO> donacionesRecientes();


    List<Donacion> findByDonanteId(Long donanteId);


    @Query(value = "SELECT d.donante_id, u.nombre, SUM(d.monto) AS total_donado " +
            "FROM donacion d JOIN usuario u ON d.donante_id = u.id " +
            "GROUP BY d.donante_id, u.nombre", nativeQuery = true)
    List<Object[]> totalDonadoPorDonante();


}
