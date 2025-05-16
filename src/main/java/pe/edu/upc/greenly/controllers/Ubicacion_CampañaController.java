package pe.edu.upc.greenly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greenly.dtos.Ubicacion_CampañaDTO;
import pe.edu.upc.greenly.dtos.UsuarioDTO;
import pe.edu.upc.greenly.service.Ubicacion_CampañaService;

import java.util.List;

@RestController
@RequestMapping("/Greenly/ubicaciones-campaña")
public class Ubicacion_CampañaController {
    @Autowired
    private Ubicacion_CampañaService ubicacionService;

    @PostMapping("/agregar")
    public ResponseEntity<Ubicacion_CampañaDTO> addUbicacion(@RequestBody Ubicacion_CampañaDTO dto) {
        return ResponseEntity.ok(ubicacionService.addUbicacion_Campaña(dto));
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Ubicacion_CampañaDTO> getUbicacion(@PathVariable Long id) {
        Ubicacion_CampañaDTO dto = ubicacionService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/listar")
    public List<Ubicacion_CampañaDTO> listUbicaciones() {
        return ubicacionService.listAll();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteUbicacion(@PathVariable Long id) {
        ubicacionService.deleteUbicacion_Campaña(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<Ubicacion_CampañaDTO> updateUbicacion_Campaña(@PathVariable Long id, @RequestBody Ubicacion_CampañaDTO ubicacion_campañaDTO) {
        return ResponseEntity.ok(ubicacionService.updateUbicacion_Campaña(id, ubicacion_campañaDTO));
    }
}
