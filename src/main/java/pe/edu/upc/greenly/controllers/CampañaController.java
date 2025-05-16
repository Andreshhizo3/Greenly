package pe.edu.upc.greenly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greenly.dtos.CampañaDTO;
import pe.edu.upc.greenly.entities.Campaña;
import pe.edu.upc.greenly.service.CampañaService;

import java.time.LocalDate;
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


    //Obtener campaña por ONG RONALD
    @GetMapping("/obtenerCampañasPorOng/{ongId}")
    public List<CampañaDTO> obtenerCampañasPorOng(@PathVariable Long ongId) {
        return campañaService.obtenerCampañasPorOng(ongId);
    }

    // Query Method Endpoint para buscar campañas por descripción y fecha ANDRES
    @GetMapping("/descripcion-fecha")
    public List<Campaña> buscarPorDescripcionYFechaInicio(
            @RequestParam("texto") String texto,
            @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio
    ) {
        return campañaService.obtenerCampañasPorDescripcionYFechaInicio(texto, fechaInicio);
    }


    // Query Method Endpoint para buscar campañas por texto en título o descripción ANDRES
    @GetMapping("/buscar")
    public List<Campaña> buscarPorTituloODescripcion(
            @RequestParam("texto") String texto) {
        return campañaService.obtenerCampañasPorTituloODescripcion(texto);
    }

    // SQL Obtener campañas cuya fecha de inicio esté entre dos fechas específicas ANDRES
    @GetMapping("/rango-fechas")
    public List<Campaña> obtenerCampañasPorRangoFechas(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin
    ) {
        return campañaService.obtenerCampañasPorRangoFechas(fechaInicio, fechaFin);
    }




}
