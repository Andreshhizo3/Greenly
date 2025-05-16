package pe.edu.upc.greenly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.greenly.entities.Campaña;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface CampañaRepository extends JpaRepository<Campaña,Long> {
    // 1. Query Method Obtener campañas por ONG ingresado (RONALD)
    List<Campaña> findByOngId(Long ongId);

    // Consulta 1: descripción contiene texto y fechaInicio después de fecha dada
    List<Campaña> findByDescripcionContainingIgnoreCaseAndFechaInicioAfter(String texto, LocalDate fechaInicio);
    // Consulta 2: campañas que contienen texto en título o descripción
    List<Campaña> findByTituloContainingIgnoreCaseOrDescripcionContainingIgnoreCase(String titulo, String descripcion);
    // Consulta 3: Obtener campañas cuya fecha de inicio esté entre dos fechas específicas
    @Query(value = "SELECT * FROM campaña " +
            "WHERE fecha_inicio BETWEEN :fechaInicio AND :fechaFin", nativeQuery = true)
    List<Campaña> obtenerCampañasPorRangoFechas(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);



}
