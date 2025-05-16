package pe.edu.upc.greenly.service;

import pe.edu.upc.greenly.dtos.OngDTO;
import pe.edu.upc.greenly.dtos.RolDTO;

import java.util.List;

public interface OngService {
    OngDTO addOng(OngDTO ongDTO);
    void deleteOng(Long id);
    OngDTO findById(Long id);
    List<OngDTO> listAll();
    OngDTO updateOng(Long id, OngDTO ongDTO);
    List<OngDTO> findOngsConCampañasEnAnio(int anio);
}
