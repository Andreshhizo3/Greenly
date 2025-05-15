package pe.edu.upc.greenly.service;

import pe.edu.upc.greenly.dtos.DonacionDTO;
import pe.edu.upc.greenly.dtos.TotalDonacionesPorCampañaDTO;
import pe.edu.upc.greenly.entities.Donacion;
import pe.edu.upc.greenly.entities.TipoDonacion;

import java.util.List;

public interface DonacionService {
    public DonacionDTO addDonacionDTO(DonacionDTO donacionDTO);
    public void deleteDonacion(Long id);
    public DonacionDTO findById(Long id);
    public List<DonacionDTO> listAll();
    //public Donacion editDonacion(Donacion donacionDTO);
    DonacionDTO updateDonacion(Long id, DonacionDTO dto);

    //3. SQL QUERY TOTAL DE DONACIONES POR CAMPAÑA
    List<TotalDonacionesPorCampañaDTO> obtenerTotalesPorCampaña();
}
