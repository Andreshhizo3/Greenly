package pe.edu.upc.greenly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greenly.dtos.CampañaDTO;
import pe.edu.upc.greenly.dtos.CampañaFavoritaDTO;
import pe.edu.upc.greenly.dtos.OngDTO;
import pe.edu.upc.greenly.entities.CampañaFavorita;
import pe.edu.upc.greenly.service.CampañaFavoritaService;

import java.util.List;

@RestController
@RequestMapping("/Greenly/campañasFavoritas")
public class CampañaFavoritaController {

    @Autowired
    CampañaFavoritaService campañaFavoritaService;

    /*@PostMapping
    public void insertar(@RequestBody CampañaFavorita campañaFavorita) {
        campañaFavoritaService.insert(campañaFavorita);
    }*/
    @PostMapping("/agregar")
    public ResponseEntity<CampañaFavoritaDTO> addCampañaFavorita(@RequestBody CampañaFavoritaDTO dto) {
        return ResponseEntity.ok(campañaFavoritaService.addCampañaFavorito(dto));
    }

    @GetMapping("/listar")
    public List<CampañaFavoritaDTO> listar() {
        return campañaFavoritaService.listAll();
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        campañaFavoritaService.delete(id);
    }
    @GetMapping("/obtener/{id}")
    public ResponseEntity<CampañaFavoritaDTO> getCampañaFavorita(@PathVariable Long id) {
        CampañaFavoritaDTO dto = campañaFavoritaService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<CampañaFavoritaDTO> modificarCampañaFavorita(
            @PathVariable Long id,
            @RequestBody CampañaFavoritaDTO dto) {
        CampañaFavoritaDTO updated = campañaFavoritaService.updateCampañaFavorita(id, dto);
        return ResponseEntity.ok(updated);
    }
}
