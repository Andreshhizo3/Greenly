package pe.edu.upc.greenly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greenly.dtos.DonanteDTO;
import pe.edu.upc.greenly.service.DonanteService;

import java.util.List;

@RestController
@RequestMapping("/Greenly/donantes")

public class DonanteController {
    @Autowired
    private DonanteService donanteService;

    @PostMapping
    public ResponseEntity<DonanteDTO> addDonante (@RequestBody DonanteDTO donanteDTO) {return ResponseEntity.ok(donanteService.addDonante(donanteDTO));}

    @GetMapping("{id}")
    public ResponseEntity<DonanteDTO> getDonante(@PathVariable Long id) {
        DonanteDTO donanteDTO= donanteService.findDonanteById(id);
        return donanteDTO !=null ? ResponseEntity.ok(donanteDTO) : ResponseEntity.notFound().build();

    }
    @GetMapping
    public List<DonanteDTO> listDonantes() {
        return donanteService.listAllDonantes();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDonante(@PathVariable Long id) {
        donanteService.deleteDonante(id);
        return ResponseEntity.noContent().build();

    }

}
