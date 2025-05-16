package pe.edu.upc.greenly.service;

import pe.edu.upc.greenly.dtos.CampañaDTO;
import pe.edu.upc.greenly.dtos.RolDTO;
import pe.edu.upc.greenly.entities.Campaña;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CampañaService {
    CampañaDTO addCampaña (CampañaDTO campañaDTO);
    void deleteCampaña (Long id);
    CampañaDTO findById(Long id);
    List<CampañaDTO> listAll();
    CampañaDTO updateCampaña(Long id, CampañaDTO dto);


    // Método para obtener campañas que contienen texto en título o descripción
    List<Campaña> obtenerCampañasPorTituloODescripcion(String texto);
    List<Campaña> obtenerCampañasPorDescripcionYFechaInicio(String texto, LocalDate fechaInicio);
    List<Campaña> obtenerCampañasPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin);


}
