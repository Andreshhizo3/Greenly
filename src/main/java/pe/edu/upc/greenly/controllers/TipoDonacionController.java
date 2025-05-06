package pe.edu.upc.greenly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greenly.entities.EstadoDonacion;
import pe.edu.upc.greenly.entities.TipoDonacion;
import pe.edu.upc.greenly.service.EstadoDonacionService;
import pe.edu.upc.greenly.service.TipoDonacionService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/tipoDonaciones")
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

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<TipoDonacion> actualizarTipoDonacion(@PathVariable("id") Long id, @RequestBody TipoDonacion tipoDonacion) {
        tipoDonacion.setId(id);
        TipoDonacion editTipoDonacion = tipoDonacionService.editTipoDonacion(tipoDonacion);
        return new ResponseEntity<>(editTipoDonacion,HttpStatus.OK);
    }
}
