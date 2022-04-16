package com.marielagcw.controller;

import com.marielagcw.model.dto.TurnoDTO;
import com.marielagcw.service.impl.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/turnos")
//@CrossOrigin(origins = "http://localhost:3000")
public class TurnoController {

    @Autowired
    private TurnoService service;
    /* ---------------------------------------------------------------------*/

    /* ──────────────────────────
         GUARDAR / POST
    ────────────────────────── */
    @PostMapping
    public ResponseEntity<String> postTurno(@RequestBody TurnoDTO turnoDTO) {
        if (bodyValidation(turnoDTO)) {
            service.save(turnoDTO);
            return ResponseEntity.ok().body("El turno fue guardado con éxito");
        } else return ResponseEntity.badRequest().body("El turno ingresado no es válido");
    }
    /* ---------------------------------------------------------------------*/

    /* ──────────────────────────
       BUSCAR TODOS / GET ALL
    ────────────────────────── */
    @GetMapping
    public List<TurnoDTO> getAll() {
        return service.findAll();
    }
    /* ---------------------------------------------------------------------*/

    /* ──────────────────────────
     BUSCAR POR ID / GET BY ID
    ────────────────────────── */
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        if (idValidation(id)) {
            TurnoDTO turnoResponse = service.findById(id);
            return ResponseEntity.ok(turnoResponse);
        } else return ResponseEntity.badRequest().body("El ID ingresado no es válido");
    }
    /* ---------------------------------------------------------------------*/

    /* ──────────────────────────
       ELIMINAR / DELETE BY ID
    ────────────────────────── */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        if (idValidation(id)) {
            service.deleteById(id);
            return ResponseEntity.ok().body("El turno fue eliminado con éxito");
        } else return ResponseEntity.badRequest().body("El ID ingresado no es válido");
    }
    /* ---------------------------------------------------------------------*/

    /* ──────────────────────────
       MODIFICAR POR ID / PUT
    ────────────────────────── */
    @PutMapping(path = "/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody TurnoDTO turnoDto) {
        if (bodyValidation(turnoDto) && idValidation(id)) {
            turnoDto.setId(id);
            service.update(turnoDto);
            return ResponseEntity.ok().body("El turno se modificó con éxito");
        } else return ResponseEntity.badRequest().body("Los datos ingresados no son válidos");
    }

    /* ──────────────────────────
             VALIDACIONES
    ────────────────────────── */
    public boolean bodyValidation(TurnoDTO turnoDTO) {
        if (turnoDTO != null) {
            return true;
        } else return false;
    }

    public boolean idValidation(Integer id) {
        if (id != null) {
            return true;
        } else return false;
    }
}
