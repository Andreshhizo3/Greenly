package pe.edu.upc.greenly.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greenly.dtos.OngDTO;
import pe.edu.upc.greenly.entities.Ong;
import pe.edu.upc.greenly.entities.Usuario;
import pe.edu.upc.greenly.repositories.OngRepository;
import pe.edu.upc.greenly.repositories.UsuarioRepository;
import pe.edu.upc.greenly.service.OngService;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class OngServiceImpl implements OngService {
    @Autowired
    private OngRepository ongRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public OngDTO addOng(OngDTO ongDTO) {
        Usuario usuario = usuarioRepository.findById(ongDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + ongDTO.getUsuarioId()));

        Ong ong = new Ong();
        ong.setNombre(ongDTO.getNombre());
        ong.setDescripcion(ongDTO.getDescripcion());
        ong.setCorreo(ongDTO.getCorreo());
        ong.setDireccion(ongDTO.getDireccion());
        ong.setTelefono(ongDTO.getTelefono());
        ong.setUsuario(usuario);

        Ong savedOng = ongRepository.save(ong);

        return new OngDTO(
                savedOng.getId(),
                savedOng.getNombre(),
                savedOng.getDescripcion(),
                savedOng.getCorreo(),
                savedOng.getDireccion(),
                savedOng.getTelefono(),
                savedOng.getUsuario().getId()
        );
    }

    @Override
    public void deleteOng(Long id) {
        ongRepository.deleteById(id);
    }

    @Override
    public OngDTO findById(Long id) {
        Ong ong = ongRepository.findById(id).orElse(null);
        //if (ong == null || ong.getUsuario() == null) {
        if (ong == null) {
            return null;
        }

        return new OngDTO(
                ong.getId(),
                ong.getNombre(),
                ong.getDescripcion(),
                ong.getCorreo(),
                ong.getDireccion(),
                ong.getTelefono(),
                //ong.getUsuario().getId()
                ong.getUsuario() != null ? ong.getUsuario().getId() : null
        );
    }

    @Override
    public List<OngDTO> listAll() {
        List<Ong> ongs = ongRepository.findAll();
        return ongs.stream()
                //.filter(ong -> ong.getUsuario() != null)
                .map(ong -> new OngDTO(
                        ong.getId(),
                        ong.getNombre(),
                        ong.getDescripcion(),
                        ong.getCorreo(),
                        ong.getDireccion(),
                        ong.getTelefono(),
                        //ong.getUsuario().getId()
                        //Para que acepte las ONG con usuarioId null tambien
                        ong.getUsuario() != null ? ong.getUsuario().getId(): null
                ))
                .collect(Collectors.toList());
    }

    /*@Override
    public OngDTO updateOng(Long id, OngDTO ongDTO) {
        // Buscar la ONG por ID
        Ong ong = ongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ONG no encontrada con ID: " + id));

        // Si el DTO incluye un usuarioId, buscar el usuario relacionado
        Usuario usuario = null;
        if (ongDTO.getUsuarioId() != null) {
            usuario = usuarioRepository.findById(ongDTO.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + ongDTO.getUsuarioId()));
        }

        // Actualizar los campos de la entidad ONG
        ong.setNombre(ongDTO.getNombre());
        ong.setDescripcion(ongDTO.getDescripcion());
        ong.setCorreo(ongDTO.getCorreo());
        ong.setDireccion(ongDTO.getDireccion());
        ong.setTelefono(ongDTO.getTelefono());
        ong.setUsuario(usuario);  // Puede ser null si se desea desvincular

        // Guardar los cambios
        Ong updatedOng = ongRepository.save(ong);

        // Retornar el DTO actualizado
        return new OngDTO(
                updatedOng.getId(),
                updatedOng.getNombre(),
                updatedOng.getDescripcion(),
                updatedOng.getCorreo(),
                updatedOng.getDireccion(),
                updatedOng.getTelefono(),
                updatedOng.getUsuario() != null ? updatedOng.getUsuario().getId() : null
        );
    }*/

    @Override
    public OngDTO updateOng(Long id, OngDTO ongDTO) {
        Ong ong = ongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ONG no encontrada con ID: " + id));

        // Solo actualizar si no es null
        if (ongDTO.getNombre() != null) {
            ong.setNombre(ongDTO.getNombre());
        }
        if (ongDTO.getDescripcion() != null) {
            ong.setDescripcion(ongDTO.getDescripcion());
        }
        if (ongDTO.getCorreo() != null) {
            ong.setCorreo(ongDTO.getCorreo());
        }
        if (ongDTO.getDireccion() != null) {
            ong.setDireccion(ongDTO.getDireccion());
        }
        if (ongDTO.getTelefono() != null) {
            ong.setTelefono(ongDTO.getTelefono());
        }

        // Solo actualizar usuario si se envía un ID
        if (ongDTO.getUsuarioId() != null) {
            Usuario usuario = usuarioRepository.findById(ongDTO.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + ongDTO.getUsuarioId()));
            ong.setUsuario(usuario);
        }

        Ong updatedOng = ongRepository.save(ong);

        return new OngDTO(
                updatedOng.getId(),
                updatedOng.getNombre(),
                updatedOng.getDescripcion(),
                updatedOng.getCorreo(),
                updatedOng.getDireccion(),
                updatedOng.getTelefono(),
                updatedOng.getUsuario() != null ? updatedOng.getUsuario().getId() : null
        );
    }
    public List<OngDTO> findOngsConCampañasEnAnio(int anio) {
        List<Ong> ongs = ongRepository.findOngsConCampañasEnAnio(anio);
        return ongs.stream()
                .map(ong -> new OngDTO(
                        ong.getId(),
                        ong.getNombre(),
                        ong.getDescripcion(),
                        ong.getCorreo(),
                        ong.getDireccion(),
                        ong.getTelefono(),
                        ong.getUsuario() != null ? ong.getUsuario().getId() : null
                ))
                .collect(Collectors.toList());
    }
}
