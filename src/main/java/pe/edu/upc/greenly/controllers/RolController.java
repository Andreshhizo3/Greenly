package pe.edu.upc.greenly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greenly.dtos.RolDTO;
import pe.edu.upc.greenly.service.RolService;

import java.util.List;

@RestController
@RequestMapping("/Greenly/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping
    public ResponseEntity<RolDTO> addRol(@RequestBody RolDTO dto) {
        return ResponseEntity.ok(rolService.addRol(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> getRol(@PathVariable Long id) {
        RolDTO dto = rolService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<RolDTO> listRoles() {
        return rolService.listAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Long id) {
        rolService.deleteRol(id);
        return ResponseEntity.noContent().build();
    }
}