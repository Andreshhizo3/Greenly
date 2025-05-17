package pe.edu.upc.greenly.service;

import pe.edu.upc.greenly.dtos.EstadoDonacionDTO;
import pe.edu.upc.greenly.entities.EstadoDonacion;

import java.util.List;

public interface EstadoDonacionService {
    public EstadoDonacion addEstadoDonacion(EstadoDonacion estadoDonacion);
    public void deleteEstadoDonacion(Long id);
    //public EstadoDonacion findById(Long id);
    EstadoDonacionDTO findById (Long id);
    public List<EstadoDonacion> listAll();
    //public EstadoDonacion editEstadoDonacion(EstadoDonacion estadoDonacion);
    EstadoDonacionDTO updateEstadoDonacion(Long id, EstadoDonacionDTO estadoDonacionDTO);
}
