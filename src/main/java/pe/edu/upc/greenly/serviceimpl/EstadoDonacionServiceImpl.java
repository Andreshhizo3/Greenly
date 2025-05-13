package pe.edu.upc.greenly.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greenly.dtos.EstadoDonacionDTO;
import pe.edu.upc.greenly.dtos.TipoDonacionDTO;
import pe.edu.upc.greenly.entities.EstadoDonacion;
import pe.edu.upc.greenly.entities.TipoDonacion;
import pe.edu.upc.greenly.repositories.EstadoDonacionRepository;
import pe.edu.upc.greenly.service.EstadoDonacionService;

import java.util.List;

@Service
public class EstadoDonacionServiceImpl implements EstadoDonacionService {

    @Autowired
    private EstadoDonacionRepository estadoDonacionRepository;


    @Override
    public EstadoDonacion addEstadoDonacion(EstadoDonacion estadoDonacion) {

        if (estadoDonacion.getEstado() == null || estadoDonacion.getEstado().isEmpty()) {
            return null; // mensaje de error: "El estado del tipo de estado no puede estar vacio"
        }

        if (estadoDonacion.getFecha() == null || estadoDonacion.getEstado().isEmpty()) {
            return null; // mensaje de error: "La fecha del tipo de estado no puede estar vacio"
        }

        return estadoDonacionRepository.save(estadoDonacion);
    }

    /*@Override
    public void deleteEstadoDonacion(Long id) {
        EstadoDonacion estadoDonacionEncontrado = findById(id);
        if (estadoDonacionEncontrado != null) {
            estadoDonacionRepository.delete(estadoDonacionEncontrado);
        }
    }*/

    /*@Override
    public EstadoDonacion findById(Long id) {
        return estadoDonacionRepository.findById(id).orElse(null);
    }*/

    @Override
    public EstadoDonacionDTO findById (Long id){
        EstadoDonacion estadoDonacion = estadoDonacionRepository.findById(id).orElse(null);
        //if (estadoDonacion == null || estadoDonacion.getUsuario() == null) {
        if (estadoDonacion == null) {
            return null;
        }

        return new EstadoDonacionDTO(
                estadoDonacion.getId(),
                estadoDonacion.getEstado(),
                estadoDonacion.getFecha()

        );
    }

    @Override
    public List<EstadoDonacion> listAll() {
        return estadoDonacionRepository.findAll();
    }

    /*@Override
    public EstadoDonacion editEstadoDonacion(EstadoDonacion estadoDonacion) {
        EstadoDonacion estadoDonacionEncontrado = findById(estadoDonacion.getId());

        if (estadoDonacion.getEstado() != null || !estadoDonacion.getEstado().isEmpty()) {
            estadoDonacionEncontrado.setEstado(estadoDonacion.getEstado());
        }
        if (estadoDonacion.getFecha() != null || !estadoDonacion.getEstado().isEmpty()) {
            estadoDonacionEncontrado.setFecha(estadoDonacion.getFecha());
        }

        List<EstadoDonacion> estadoDonaciones = estadoDonacionRepository.findByEstado(estadoDonacion.getEstado());
        if (estadoDonaciones != null && !estadoDonaciones.isEmpty()) {
            return null;
        }

        return estadoDonacionRepository.save(estadoDonacionEncontrado);
    }*/

    @Override
    public EstadoDonacionDTO updateEstadoDonacion(Long id, EstadoDonacionDTO estadoDonacionDTO) {
        // Buscar el EstadoDonacion por ID
        EstadoDonacion estadoDonacion = estadoDonacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EstadoDonacion no encontrada con ID: " + id));
        // Actualizar solo si los valores no son null
        if (estadoDonacionDTO.getEstado() != null) {
            estadoDonacion.setEstado(estadoDonacionDTO.getEstado());
        }
        if (estadoDonacionDTO.getFecha() != null) {
            estadoDonacion.setFecha(estadoDonacionDTO.getFecha());
        }
        // Guardar los cambios
        EstadoDonacion updatedEstadoDonacion = estadoDonacionRepository.save(estadoDonacion);
        // Retornar el DTO actualizado
        return new EstadoDonacionDTO(
                updatedEstadoDonacion.getId(),
                updatedEstadoDonacion.getEstado(),
                updatedEstadoDonacion.getFecha()
        );
    }

    @Override
    public void deleteEstadoDonacion(Long id) {
        /*TipoDonacionDTO tipoDonacionEncontrado = findById(id);
        if (tipoDonacionEncontrado != null) {
            tipoDonacionRepository.delete(tipoDonacionEncontrado);
        }*/
        estadoDonacionRepository.deleteById(id);
    }
}
