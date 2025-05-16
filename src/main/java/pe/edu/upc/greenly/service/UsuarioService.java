package pe.edu.upc.greenly.service;

import pe.edu.upc.greenly.dtos.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    UsuarioDTO addUsuario(UsuarioDTO usuarioDTO);
    void deleteUsuario(Long id);
    UsuarioDTO findById(Long id);
    List<UsuarioDTO> listAll();
    UsuarioDTO updateUsuario(Long id,UsuarioDTO usuarioDTO);
}