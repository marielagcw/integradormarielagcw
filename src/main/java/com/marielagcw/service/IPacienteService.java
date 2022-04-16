package com.marielagcw.service;


import com.marielagcw.model.dto.PacienteDTO;
import com.marielagcw.model.entity.Paciente;
import java.util.List;

public interface IPacienteService {

    /* ──────────────
       MÉTODOS CRUD
     ────────────── */

    // GUARDAR
    void save(PacienteDTO pacienteDTO);

    // BUSCAR TODOS
    List<PacienteDTO> findAll();

    // BUSCAR POR ID
    PacienteDTO findById(Integer id);

    // ELIMINAR POR ID
    void deleteById(Integer id);

    // MODIFICAR POR ID
    void update(PacienteDTO pacienteDTO);

}
