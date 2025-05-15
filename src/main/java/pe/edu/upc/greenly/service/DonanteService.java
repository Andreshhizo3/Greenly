package pe.edu.upc.greenly.service;

import pe.edu.upc.greenly.dtos.DonanteDTO;
import pe.edu.upc.greenly.entities.Donante;

import java.util.List;

public interface DonanteService {
    DonanteDTO addDonante(DonanteDTO donanteDTO);
    void deleteDonante(Long id);
    DonanteDTO findDonanteById(Long id);
    List<DonanteDTO> listAllDonantes();
    DonanteDTO updateDonante(Long id, DonanteDTO donanteDTO);
    List<Donante> obtenerDonantesPorCampaña(Long campañaId);
    List<Donante> findDonantesConMasDeXDonaciones(int cantidadMinima);
}
