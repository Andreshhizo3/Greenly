package pe.edu.upc.greenly.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greenly.dtos.DonanteDTO;
import pe.edu.upc.greenly.dtos.OngDTO;
import pe.edu.upc.greenly.entities.Donante;
import pe.edu.upc.greenly.entities.Ong;
import pe.edu.upc.greenly.entities.Usuario;
import pe.edu.upc.greenly.repositories.DonanteRepository;
import pe.edu.upc.greenly.repositories.UsuarioRepository;
import pe.edu.upc.greenly.service.DonanteService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonanteServiceImpl implements DonanteService {
    @Autowired
    private DonanteRepository donanteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public DonanteDTO addDonante(DonanteDTO donanteDTO) {
        Usuario usuario = usuarioRepository.findById(donanteDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + donanteDTO.getUsuarioId()));

        Donante donante = new Donante();
        donante.setNombre(donanteDTO.getNombre());
        donante.setDni(donanteDTO.getDni());
        donante.setCorreo(donanteDTO.getCorreo());
        donante.setTelefono(donanteDTO.getTelefono());
        donante.setDireccion(donanteDTO.getDireccion());
        donante.setFechaNacimiento(donanteDTO.getFechaNacimiento());
        donante.setUsuario(usuario);

        Donante savedDonante = donanteRepository.save(donante);

        return new DonanteDTO(
                savedDonante.getId(),
                savedDonante.getNombre(),
                savedDonante.getDni(),
                savedDonante.getCorreo(),
                savedDonante.getTelefono(),
                savedDonante.getDireccion(),
                savedDonante.getFechaNacimiento(),
                savedDonante.getUsuario().getId()
        );
    }

    public void deleteDonante(Long id) {donanteRepository.deleteById(id);}

    public DonanteDTO findDonanteById(Long id) {
        Donante donante = donanteRepository.findById(id).orElse(null);
        if (donante == null || donante.getUsuario() == null) {
            return null;
        }

        return new DonanteDTO(
                donante.getId(),
                donante.getNombre(),
                donante.getDni(),
                donante.getCorreo(),
                donante.getTelefono(),
                donante.getDireccion(),
                donante.getFechaNacimiento(),
                donante.getUsuario().getId()
        );
    }
    @Override
    public List<DonanteDTO> listAllDonantes(){
        List<Donante> donantes=donanteRepository.findAll();
        return donantes.stream()
                .filter(donante -> donante.getUsuario() != null)
                .map(donante -> new DonanteDTO(
                        donante.getId(),
                        donante.getNombre(),
                        donante.getDni(),
                        donante.getCorreo(),
                        donante.getTelefono(),
                        donante.getDireccion(),
                        donante.getFechaNacimiento(),
                        donante.getUsuario().getId()
                ))
                .collect(Collectors.toList());
    }

    /*@Override
    public DonanteDTO updateDonante(Long id, DonanteDTO donanteDTO) {
        // Buscar la Donante por ID
        Donante donante = donanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donante no encontrada con ID: " + id));

        // Si el DTO incluye un usuarioId, buscar el usuario relacionado
        Usuario usuario = null;
        if (donanteDTO.getUsuarioId() != null) {
            usuario = usuarioRepository.findById(donanteDTO.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + donanteDTO.getUsuarioId()));
        }

        // Actualizar los campos de la entidad Donante
        donante.setNombre(donanteDTO.getNombre());
        donante.setDni(donanteDTO.getDni());
        donante.setCorreo(donanteDTO.getCorreo());
        donante.setTelefono(donanteDTO.getTelefono());
        donante.setFechaNacimiento(donanteDTO.getFechaNacimiento());
        donante.setUsuario(usuario); //Puede ser null si se desea desvincular

        // Guardar los cambios
        Donante updatedDonante = donanteRepository.save(donante);

        // Retornar el DTO actualizado
        return new DonanteDTO(
                updatedDonante.getId(),
                updatedDonante.getNombre(),
                updatedDonante.getDni(),
                updatedDonante.getCorreo(),
                updatedDonante.getTelefono(),
                updatedDonante.getDireccion(),
                updatedDonante.getFechaNacimiento(),
                updatedDonante.getUsuario() !=null ? updatedDonante.getUsuario().getId() : null
        );
    }*/

    @Override
    public DonanteDTO updateDonante(Long id, DonanteDTO donanteDTO) {
        // Buscar la Donante por ID
        Donante donante = donanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donante no encontrada con ID: " + id));

        // Actualizar campos solo si no son null
        if (donanteDTO.getNombre() != null) {
            donante.setNombre(donanteDTO.getNombre());
        }

        if (donanteDTO.getDni() != null) {
            donante.setDni(donanteDTO.getDni());
        }

        if (donanteDTO.getCorreo() != null) {
            donante.setCorreo(donanteDTO.getCorreo());
        }

        if (donanteDTO.getTelefono() != null) {
            donante.setTelefono(donanteDTO.getTelefono());
        }

        if (donanteDTO.getFechaNacimiento() != null) {
            donante.setFechaNacimiento(donanteDTO.getFechaNacimiento());
        }

        if (donanteDTO.getDireccion() != null) {
            donante.setDireccion(donanteDTO.getDireccion());
        }

        // Actualizar usuario si viene el ID, si es null se desvincula
        if (donanteDTO.getUsuarioId() != null) {
            Usuario usuario = usuarioRepository.findById(donanteDTO.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + donanteDTO.getUsuarioId()));
            donante.setUsuario(usuario);
        /*} else if (donanteDTO.getUsuarioId() == null) {
            donante.setUsuario(null); // Desvincular si explícitamente se manda null
            */
        }

        // Guardar los cambios
        Donante updatedDonante = donanteRepository.save(donante);

        // Retornar el DTO actualizado
        return new DonanteDTO(
                updatedDonante.getId(),
                updatedDonante.getNombre(),
                updatedDonante.getDni(),
                updatedDonante.getCorreo(),
                updatedDonante.getTelefono(),
                updatedDonante.getDireccion(),
                updatedDonante.getFechaNacimiento(),
                updatedDonante.getUsuario() != null ? updatedDonante.getUsuario().getId() : null
        );
    }

    public List<Donante> obtenerDonantesPorCampaña(Long campañaId) {
        return donanteRepository.findDonantesByCampañaId(campañaId);
    }
    public List<Donante> findDonantesConMasDeXDonaciones(int cantidadMinima) {
        return donanteRepository.findDonantesConMasDeXDonaciones(cantidadMinima);
    }

}
