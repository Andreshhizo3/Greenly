package pe.edu.upc.greenly.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greenly.dtos.RolDTO;
import pe.edu.upc.greenly.dtos.Ubicacion_CampañaDTO;
import pe.edu.upc.greenly.dtos.UsuarioDTO;
import pe.edu.upc.greenly.entities.Rol;
import pe.edu.upc.greenly.entities.Ubicacion_Campaña;
import pe.edu.upc.greenly.dtos.UsuarioDTO;
import pe.edu.upc.greenly.entities.Usuario;
import pe.edu.upc.greenly.repositories.UsuarioRepository;
import pe.edu.upc.greenly.service.RolService;
import pe.edu.upc.greenly.service.UsuarioService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolService rolService;

    @Override
    public UsuarioDTO addUsuario(UsuarioDTO usuarioDTO) {
        //RolDTO rolDTO = usuarioDTO.getRol();
        //Rol rol = new Rol(rolDTO.getId(), rolDTO.getRol());
        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setEnable(usuarioDTO.isEnable());

        Usuario savedUsuario = usuarioRepository.save(usuario);
        return new UsuarioDTO(savedUsuario.getId(), savedUsuario.getUsername(), savedUsuario.getPassword(), savedUsuario.isEnable());
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            //RolDTO rolDTO = new RolDTO(usuario.getRol().getId(), usuario.getRol().getRol());
            return new UsuarioDTO(usuario.getId(), usuario.getUsername(), usuario.getPassword(), usuario.isEnable());
        }
        return null;
    }

    @Override
    public List<UsuarioDTO> listAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> new UsuarioDTO(usuario.getId(), usuario.getUsername(), usuario.getPassword(), usuario.isEnable()))
                .collect(Collectors.toList());
    }



    /*@Override
    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setEnable(usuarioDTO.isEnable());

        Usuario updatedUsuario = usuarioRepository.save(usuario);
        return new UsuarioDTO(updatedUsuario.getId(), updatedUsuario.getUsername(), updatedUsuario.getPassword(), updatedUsuario.isEnable());
    }*/

    @Override
    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrada con ID: " + id);
        }

        if (usuarioDTO.getUsername() != null) {
            usuario.setUsername(usuarioDTO.getUsername());
        }

        if (usuarioDTO.getPassword() != null) {
            usuario.setPassword(usuarioDTO.getPassword());
        }

        if (usuarioDTO.isEnable() != null) {
            usuario.setEnable(usuarioDTO.isEnable());
        }

        Usuario updateUsuario = usuarioRepository.save(usuario);

        return new UsuarioDTO(
                updateUsuario.getId(),
                updateUsuario.getUsername(),
                updateUsuario.getPassword(),
                updateUsuario.isEnable()
        );
    }
}