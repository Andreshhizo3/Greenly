package pe.edu.upc.greenly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greenly.dtos.CampañaDTO;
import pe.edu.upc.greenly.dtos.ComentarioDTO;
import pe.edu.upc.greenly.dtos.TipoDonacionDTO;
import pe.edu.upc.greenly.entities.EstadoDonacion;
import pe.edu.upc.greenly.dtos.TipoDonacionDTO;
import pe.edu.upc.greenly.entities.TipoDonacion;
import pe.edu.upc.greenly.service.TipoDonacionService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Greenly/tipoDonaciones")
public class TipoDonacionController {

    @Autowired
    private TipoDonacionService tipoDonacionService;

    @GetMapping("/listar")
    // http://localhost:8080/tipoDonaciones/listar
    public List<TipoDonacion> listarTodo(){
        return tipoDonacionService.listAll();
    }

    @PostMapping("/agregar")
    // http://localhost:8080/tipoDonaciones/agregar
    public ResponseEntity<TipoDonacion> insertarTipoDonacion(@RequestBody TipoDonacion tipoDonacion) {
        TipoDonacion tipoDonacionNueva = tipoDonacionService.addTipoDonacion(tipoDonacion);
        return new ResponseEntity<>(tipoDonacionNueva, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    // http://localhost:8080/tipoDonaciones/eliminar/1
    public ResponseEntity<HttpStatus> eliminarTipoDonacion(@PathVariable("id") Long id) {
        tipoDonacionService.deleteTipoDonacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<TipoDonacionDTO> getTipoDonacion(@PathVariable Long id) {
        TipoDonacionDTO dto = tipoDonacionService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    /*@PutMapping("/modificar/{id}")
    public ResponseEntity<TipoDonacion> actualizarTipoDonacion(@PathVariable("id") Long id, @RequestBody TipoDonacion tipoDonacion) {
        tipoDonacion.setId(id);
        TipoDonacion editTipoDonacion = tipoDonacionService.editTipoDonacion(tipoDonacion);
        return new ResponseEntity<>(editTipoDonacion,HttpStatus.OK);
    }*/

    @PutMapping("/modificar/{id}")
    public ResponseEntity<TipoDonacionDTO> updateTipoDonacion(@PathVariable Long id, @RequestBody TipoDonacionDTO tipoDonacionDTO) {
        TipoDonacionDTO updatedTipoDonacion = tipoDonacionService.updateTipoDonacion(id, tipoDonacionDTO);
        return ResponseEntity.ok(updatedTipoDonacion);
    }
}
