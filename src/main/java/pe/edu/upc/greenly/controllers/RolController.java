package pe.edu.upc.greenly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greenly.dtos.RolDTO;
import pe.edu.upc.greenly.service.RolService;

import java.util.List;

@RestController
@RequestMapping("/Greenly/roless")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping
    public RolDTO addRol(@RequestBody RolDTO rolDTO) {
        return rolService.addRol(rolDTO);
    }

    @GetMapping("/{id}")
    public RolDTO getRol(@PathVariable int id) {
        return rolService.findById(id);
    }

    @GetMapping
    public List<RolDTO> getAllRoles() {
        return rolService.listAll();
    }

    @DeleteMapping("/{id}")
    public void deleteRol(@PathVariable int id) {
        rolService.deleteRol(id);
    }
}