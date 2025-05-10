package pe.edu.upc.greenly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greenly.dtos.UsuarioDTO;
import pe.edu.upc.greenly.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/Greenly/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/agregar")
    public ResponseEntity<UsuarioDTO> addUsuario(@RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(usuarioService.addUsuario(dto));
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable Long id) {
        UsuarioDTO dto = usuarioService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/listar")
    public List<UsuarioDTO> listUsuarios() {
        return usuarioService.listAll();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable Long id,@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.updateUsuario(id, usuarioDTO));
    }
}