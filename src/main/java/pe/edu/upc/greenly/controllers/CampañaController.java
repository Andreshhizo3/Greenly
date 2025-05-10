package pe.edu.upc.greenly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greenly.dtos.CampañaDTO;
import pe.edu.upc.greenly.service.CampañaService;

import java.util.List;

@RestController
@RequestMapping("/Greenly/campañas")
public class CampañaController {
    @Autowired
    private CampañaService campañaService;

    @PostMapping("/agregar")
    public ResponseEntity<CampañaDTO> addCampaña(@RequestBody CampañaDTO dto) {
        return ResponseEntity.ok(campañaService.addCampaña(dto));
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<CampañaDTO> getCampaña(@PathVariable Long id) {
        CampañaDTO dto = campañaService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/listar")
    public List<CampañaDTO> listCampañas() {
        return campañaService.listAll();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteCampaña(@PathVariable Long id) {
        campañaService.deleteCampaña(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/modificar/{id}")
    public ResponseEntity<CampañaDTO> modificarCampaña(
            @PathVariable Long id,
            @RequestBody CampañaDTO dto) {
        CampañaDTO updated = campañaService.updateCampaña(id, dto);
        return ResponseEntity.ok(updated);
    }
}
