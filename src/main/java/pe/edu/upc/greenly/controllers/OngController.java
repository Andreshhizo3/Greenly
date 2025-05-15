package pe.edu.upc.greenly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greenly.dtos.OngDTO;
import pe.edu.upc.greenly.service.OngService;

import java.util.List;

@RestController
@RequestMapping("/Greenly/ongs")
// http://localhost:8080/Greenly/ongs/...
public class OngController {
    @Autowired
    private OngService ongService;
//Funciona
    @PostMapping("/agregar")
    public ResponseEntity<OngDTO> addOng(@RequestBody OngDTO dto) {
        return ResponseEntity.ok(ongService.addOng(dto));
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<OngDTO> getOng(@PathVariable Long id) {
        OngDTO dto = ongService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/listar")
    public List<OngDTO> listOngs() {
        return ongService.listAll();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteOng(@PathVariable Long id) {
        ongService.deleteOng(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<OngDTO> updateOng(@PathVariable Long id, @RequestBody OngDTO ongDTO) {
        OngDTO updatedOng = ongService.updateOng(id, ongDTO);
        return ResponseEntity.ok(updatedOng);
    }
    @GetMapping("/campanas-anio/{anio}")
    public ResponseEntity<List<OngDTO>> getOngsPorAnioCampañas(@PathVariable int anio) {
        List<OngDTO> resultado = ongService.findOngsConCampañasEnAnio(anio);
        return ResponseEntity.ok(resultado);
    }
}
