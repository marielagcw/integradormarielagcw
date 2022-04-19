package com.marielagcw.service;


import com.marielagcw.exception.BadRequestException;
import com.marielagcw.model.dto.TurnoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITurnoService {

    /* ──────────────
       MÉTODOS CRUD
     ────────────── */

    // GUARDAR
    void save(TurnoDTO turnoDTO) throws BadRequestException;

    // BUSCAR TODOS
    List<TurnoDTO> findAll();

    // BUSCAR POR ID
    TurnoDTO findById(Integer id);

    // ELIMINAR POR ID
    void deleteById(Integer id);

    // MODIFICAR POR ID
    void update(TurnoDTO turnoDto);

}
