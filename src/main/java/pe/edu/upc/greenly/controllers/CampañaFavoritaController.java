package pe.edu.upc.greenly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greenly.entities.CampañaFavorita;
import pe.edu.upc.greenly.service.CampañaFavoritaService;

import java.util.List;

@RestController
@RequestMapping("/campañas-favoritas")
public class CampañaFavoritaController {

    @Autowired
    private CampañaFavoritaService cfS;

    @PostMapping
    public void insertar(@RequestBody CampañaFavorita campañaFavorita) {
        cfS.insert(campañaFavorita);
    }

    @GetMapping
    public List<CampañaFavorita> listar() {
        return cfS.list();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        cfS.delete(id);
    }
}
