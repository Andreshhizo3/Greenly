package pe.edu.upc.greenly.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greenly.dtos.OngDTO;
import pe.edu.upc.greenly.dtos.PostDTO;
import pe.edu.upc.greenly.dtos.TipoDonacionDTO;
import pe.edu.upc.greenly.entities.*;
import pe.edu.upc.greenly.dtos.TipoDonacionDTO;
import pe.edu.upc.greenly.entities.TipoDonacion;
import pe.edu.upc.greenly.repositories.TipoDonacionRepository;
import pe.edu.upc.greenly.service.TipoDonacionService;

import java.util.List;

@Service
public class TipoDonacionServiceImpl implements TipoDonacionService {

    @Autowired
    private TipoDonacionRepository tipoDonacionRepository;

    @Override
    public TipoDonacion addTipoDonacion(TipoDonacion tipoDonacion) {

        if (tipoDonacion.getNombre() == null || tipoDonacion.getNombre().isEmpty()) {
            return null; // mensaje de error: "El estado del tipo de estado no puede estar vacio"
        }

        return tipoDonacionRepository.save(tipoDonacion);
    }

    @Override
    public void deleteTipoDonacion(Long id) {
        /*TipoDonacionDTO tipoDonacionEncontrado = findById(id);
        if (tipoDonacionEncontrado != null) {
            tipoDonacionRepository.delete(tipoDonacionEncontrado);
        }*/
        tipoDonacionRepository.deleteById(id);
    }

    /*@Override
    public TipoDonacion findById(Long id) {
        return tipoDonacionRepository.findById(id).orElse(null);
    }*/

    @Override
    public List<TipoDonacion> listAll() {
        return tipoDonacionRepository.findAll();
    }

    /*@Override
    public TipoDonacion editTipoDonacion(TipoDonacion tipoDonacion) {
        TipoDonacionDTO tipoDonacionEncontrado = findById(tipoDonacion.getId());

        if (tipoDonacion.getNombre() != null || !tipoDonacion.getNombre().isEmpty()) {
            tipoDonacionEncontrado.setNombre(tipoDonacion.getNombre());
        }

        List<TipoDonacion> tipoDonaciones = tipoDonacionRepository.findByNombre(tipoDonacion.getNombre());
        if (tipoDonaciones != null && !tipoDonaciones.isEmpty()) {
            return null;
        }

        return tipoDonacionRepository.save(tipoDonacionEncontrado);
    }*/

    @Override
    public TipoDonacionDTO updateTipoDonacion(Long id, TipoDonacionDTO tipoDonacionDTO) {
        // Buscar el TipoDonacion por ID
        TipoDonacion tipoDonacion = tipoDonacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoDonacion no encontrada con ID: " + id));
        // Actualizar solo si los valores no son null
        if (tipoDonacionDTO.getNombre() != null) {
            tipoDonacion.setNombre(tipoDonacionDTO.getNombre());
        }
            // Guardar los cambios
            TipoDonacion updatedTipoDonacion = tipoDonacionRepository.save(tipoDonacion);
            // Retornar el DTO actualizado
            return new TipoDonacionDTO(
                    updatedTipoDonacion.getId(),
                    updatedTipoDonacion.getNombre()
            );
    }


        @Override
        public TipoDonacionDTO findById (Long id){
            TipoDonacion tipoDonacion = tipoDonacionRepository.findById(id).orElse(null);
            //if (tipoDonacion == null || tipoDonacion.getUsuario() == null) {
            if (tipoDonacion == null) {
                return null;
            }

            return new TipoDonacionDTO(
                    tipoDonacion.getId(),
                    tipoDonacion.getNombre()

            );
        }
    }
