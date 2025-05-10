package pe.edu.upc.greenly.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greenly.dtos.DonanteDTO;
import pe.edu.upc.greenly.entities.Donante;
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
}
