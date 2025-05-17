package pe.edu.upc.greenly.service;

import pe.edu.upc.greenly.dtos.Ubicacion_CampañaDTO;

import java.util.List;

public interface Ubicacion_CampañaService {
    Ubicacion_CampañaDTO addUbicacion_Campaña(Ubicacion_CampañaDTO ubicacion_campañaDTO);
    void deleteUbicacion_Campaña(Long id);
    Ubicacion_CampañaDTO findById(Long id);
    List<Ubicacion_CampañaDTO> listAll();
    Ubicacion_CampañaDTO updateUbicacion_Campaña(Long id, Ubicacion_CampañaDTO ubicacion_campañaDTO);
}
