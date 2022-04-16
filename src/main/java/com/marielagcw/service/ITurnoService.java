package com.marielagcw.service;


import com.marielagcw.model.dto.TurnoDTO;
import java.util.List;

public interface ITurnoService {

    /* ──────────────
       MÉTODOS CRUD
     ────────────── */

    // GUARDAR
    void save(TurnoDTO turnoDTO);

    // BUSCAR TODOS
    List<TurnoDTO> findAll();

    // BUSCAR POR ID
    TurnoDTO findById(Integer id);

    // ELIMINAR POR ID
    void deleteById(Integer id);

    // MODIFICAR POR ID
    void update(TurnoDTO turnoDto);

}
