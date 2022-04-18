package com.marielagcw.controller;

import com.marielagcw.model.dto.PacienteDTO;
import com.marielagcw.service.impl.PacienteService;
import com.marielagcw.util.controller.ControllerValidationBodyPaciente;
import com.marielagcw.util.controller.ControllerValidationId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {

    // ATRIBUTOS
    @Autowired
    private PacienteService service;
    @Autowired
    private ControllerValidationBodyPaciente validation;
    @Autowired
    private ControllerValidationId idValidation;
    /* ---------------------------------------------------------------------*/

    /* ──────────────────────────
           GUARDAR / POST
    ────────────────────────── */
    @PostMapping
    public ResponseEntity<String> postPaciente(@RequestBody PacienteDTO pacienteDTO) {
        if (validation.bodyValidation(pacienteDTO)) {
            service.save(pacienteDTO);
            return ResponseEntity.ok("El pacienteDTO se guardó con éxito");
        } else return ResponseEntity.badRequest().body("El pacienteDTO debe tener todos los campos completos");
    }
    /* ---------------------------------------------------------------------*/

    /* ──────────────────────────
      BUSCAR TODOS / GET ALL
    ────────────────────────── */
    @GetMapping
    public List<PacienteDTO> getAll() {
        return service.findAll();
    }
    /* ---------------------------------------------------------------------*/

    /* ──────────────────────────
      BUSCAR POR ID / GET BY ID
    ────────────────────────── */
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        if (idValidation.idValidation(id)) {
            PacienteDTO pacienteResponse = service.findById(id);
            return ResponseEntity.ok(pacienteResponse);
        } else return ResponseEntity.badRequest().body("El ID ingresado no es válido");
    }
    /* ---------------------------------------------------------------------*/

    /* ──────────────────────────
       ELIMINAR / DELETE BY ID
    ────────────────────────── */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        if (idValidation.idValidation(id)) {
            service.deleteById(id);
            return ResponseEntity.ok().body("El paciente fue eliminado con éxito");
        } else return ResponseEntity.badRequest().body("El ID ingresado no es válido");
    }
    /* ---------------------------------------------------------------------*/

    /* ──────────────────────────
        MODIFICAR / PUT BY ID
     ────────────────────────── */
    @PutMapping(path = "/{id}")
    public ResponseEntity<String> putById(@PathVariable Integer id, @RequestBody PacienteDTO pacienteDTO) {
        if (idValidation.idValidation(id) && validation.bodyValidation(pacienteDTO)) {
            pacienteDTO.setId(id);
            service.update(pacienteDTO);
            return ResponseEntity.ok().body("El paciente fue modificado con éxito");
        } else return ResponseEntity.badRequest().body("Los datos ingresados no son válidos");
    }
    /* ---------------------------------------------------------------------*/

}
