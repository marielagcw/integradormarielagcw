package com.marielagcw.controller;

import com.marielagcw.model.dto.OdontologoDTO;
import com.marielagcw.service.impl.OdontologoService;
import com.marielagcw.util.ControllerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/odontologos")
@CrossOrigin(origins = "*")
public class OdontologoController {

    // ATRIBUTOS
    @Autowired
    private OdontologoService service;
    @Autowired
    private ControllerValidation validation;
    /* ---------------------------------------------------------------------*/

    /* ──────────────────────────
           GUARDAR / POST
    ────────────────────────── */
    @PostMapping
    public ResponseEntity<String> postOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        if (validation.bodyValidation(odontologoDTO)) {
            service.save(odontologoDTO);
            return ResponseEntity.ok().body("El odontólogo fue guardado con éxito");
        } else return ResponseEntity.badRequest().body("El odontólogo no pudo ser guardado");
    }
    /* ---------------------------------------------------------------------*/

    /* ──────────────────────────
        BUSCAR TODOS / GET ALL
     ────────────────────────── */
    @GetMapping
    public List<OdontologoDTO> getAll() {
        return service.findAll();
    }
    /* ---------------------------------------------------------------------*/

    /* ──────────────────────────
      BUSCAR POR ID / GET BY ID
    ────────────────────────── */
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        if (validation.idValidation(id)) {
            OdontologoDTO odontologoResponse = service.findById(id);
            return ResponseEntity.ok(odontologoResponse);
        } else return ResponseEntity.badRequest().body("El Id ingresado no es válido");
    }
    /* ---------------------------------------------------------------------*/

    /* ──────────────────────────
    ELIMINAR POR ID / DELETE BY ID
    ────────────────────────── */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        if (validation.idValidation(id)) {
            service.deleteById(id);
            return ResponseEntity.ok().body("El odontólogo fue eliminado con éxito");
        } else return ResponseEntity.badRequest().body("El ID ingresado no es válido");
    }
    /* ---------------------------------------------------------------------*/

    /* ──────────────────────────
      MODIFICAR POR ID / PUT BY ID
    ────────────────────────── */
    @PutMapping(path = "{id}")
    public ResponseEntity<?> putById(@PathVariable Integer id, @RequestBody OdontologoDTO odontologoDTO) {
        if (validation.idValidation(id) && validation.bodyValidation(odontologoDTO)) {
            odontologoDTO.setId(id);
            service.update(odontologoDTO);
            return ResponseEntity.ok().body("El odontólogo fue modificado con éxito");
        } else return ResponseEntity.badRequest().body("Los datos ingresados no son válidos");
    }
    /* ---------------------------------------------------------------------*/

}

