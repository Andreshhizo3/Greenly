package pe.edu.upc.greenly.service;

import pe.edu.upc.greenly.dtos.CampañaDTO;
import pe.edu.upc.greenly.dtos.RolDTO;
import pe.edu.upc.greenly.entities.Campaña;

import java.util.List;

public interface CampañaService {
    CampañaDTO addCampaña (CampañaDTO campañaDTO);
    void deleteCampaña (Long id);
    CampañaDTO findById(Long id);
    List<CampañaDTO> listAll();
    CampañaDTO updateCampaña(Long id, CampañaDTO dto);
    //Query Method
    List<CampañaDTO> obtenerCampañasPorOng(Long ongId);
}
