package pe.edu.upc.greenly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greenly.entities.Comentario;
import pe.edu.upc.greenly.service.ComentarioService;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService cS;

    @PostMapping
    public void insertar(@RequestBody Comentario comentario) {
        cS.insert(comentario);
    }

    @GetMapping
    public List<Comentario> listar() {
        return cS.list();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        cS.delete(id);
    }
}
