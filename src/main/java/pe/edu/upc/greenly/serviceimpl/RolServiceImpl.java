package pe.edu.upc.greenly.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greenly.dtos.RolDTO;
import pe.edu.upc.greenly.entities.Rol;
import pe.edu.upc.greenly.entities.Usuario;
import pe.edu.upc.greenly.repositories.RolRepository;
import pe.edu.upc.greenly.repositories.UsuarioRepository;
import pe.edu.upc.greenly.service.RolService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public RolDTO addRol(RolDTO rolDTO) {
        Usuario usuario = usuarioRepository.findById(rolDTO.getUsuarioId()).orElseThrow(()-> new RuntimeException("Usuario no encontrado con ID: " + rolDTO.getUsuarioId()));

        Rol rol = new Rol();
        rol.setRol(rolDTO.getRol());
        rol.setUsuario(usuario);
        Rol savedRol = rolRepository.save(rol);
        return new RolDTO(savedRol.getId(), savedRol.getRol(),savedRol.getUsuario().getId());
    }

    @Override
    public void deleteRol(Long id) {
        rolRepository.deleteById(id);
    }

    @Override
    public RolDTO findById(Long id) {
        Rol rol = rolRepository.findById(id).orElse(null);
        if (rol != null) {
            return new RolDTO(rol.getId(), rol.getRol(), rol.getUsuario().getId());
        }
        return null;
    }

    @Override
    public List<RolDTO> listAll() {
        List<Rol> roles = rolRepository.findAll();
        return roles.stream()
                .filter(rol -> rol.getRol() != null)
                .map(rol -> new RolDTO(rol.getId(), rol.getRol(), rol.getUsuario().getId()))
                .collect(Collectors.toList());
    }
}