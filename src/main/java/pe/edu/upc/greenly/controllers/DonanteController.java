package pe.edu.upc.greenly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greenly.dtos.DonanteDTO;
import pe.edu.upc.greenly.dtos.OngDTO;
import pe.edu.upc.greenly.entities.Donante;
import pe.edu.upc.greenly.service.DonanteService;

import java.util.List;

@RestController
@RequestMapping("/Greenly/donantes")

public class DonanteController {
    @Autowired
    private DonanteService donanteService;

    @PostMapping("/agregar")
    public ResponseEntity<DonanteDTO> addDonante (@RequestBody DonanteDTO donanteDTO) {return ResponseEntity.ok(donanteService.addDonante(donanteDTO));}

    @GetMapping("/obtener/{id}")
    public ResponseEntity<DonanteDTO> getDonante(@PathVariable Long id) {
        DonanteDTO donanteDTO= donanteService.findDonanteById(id);
        return donanteDTO !=null ? ResponseEntity.ok(donanteDTO) : ResponseEntity.notFound().build();

    }
    @GetMapping("/listar")
    public List<DonanteDTO> listDonantes() {
        return donanteService.listAllDonantes();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteDonante(@PathVariable Long id) {
        donanteService.deleteDonante(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<DonanteDTO> updateDonante(@PathVariable Long id, @RequestBody DonanteDTO donanteDTO) {
        DonanteDTO updateDonante = donanteService.updateDonante(id, donanteDTO);
        return ResponseEntity.ok(updateDonante);
    }

    @GetMapping("/por-campaña/{id}")
    public ResponseEntity<List<Donante>> obtenerPorCampaña(@PathVariable("id") Long id) {
        List<Donante> donantes = donanteService.obtenerDonantesPorCampaña(id);
        return new ResponseEntity<>(donantes, HttpStatus.OK);
    }
    @GetMapping("/mas-donaciones/{cantidad}")
    public ResponseEntity<List<Donante>> getDonantesConMasDonaciones(@PathVariable int cantidad) {
        List<Donante> resultado = donanteService.findDonantesConMasDeXDonaciones(cantidad);
        return ResponseEntity.ok(resultado);
    }
}
