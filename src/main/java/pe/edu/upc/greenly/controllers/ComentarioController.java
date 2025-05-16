package pe.edu.upc.greenly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greenly.dtos.CampañaDTO;
import pe.edu.upc.greenly.dtos.ComentarioDTO;
import pe.edu.upc.greenly.dtos.OngDTO;
import pe.edu.upc.greenly.entities.Comentario;
import pe.edu.upc.greenly.service.ComentarioService;

import java.util.List;

@RestController
@RequestMapping("/Greenly/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService cS;
    @Autowired
    private ComentarioService comentarioService;

    /*@PostMapping
    public void insertar(@RequestBody Comentario comentario) {
        cS.insert(comentario);
    }*/

    @PostMapping("/agregar")
    public ResponseEntity<ComentarioDTO> addComentario(@RequestBody ComentarioDTO dto) {
        return ResponseEntity.ok(comentarioService.addComentario(dto));
    }

    /*@GetMapping
    public List<Comentario> listar() {
        return cS.list();
    }*/
    @GetMapping("/listar")
    public List<ComentarioDTO> listAll() {
        return comentarioService.listAll();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<ComentarioDTO> getComentario(@PathVariable Long id) {
        ComentarioDTO dto = comentarioService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        cS.delete(id);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<ComentarioDTO> updateComentario(@PathVariable Long id, @RequestBody ComentarioDTO comentarioDTO) {
        ComentarioDTO updatedComentario = comentarioService.updateComentario(id, comentarioDTO);
        return ResponseEntity.ok(updatedComentario);
    }
}
