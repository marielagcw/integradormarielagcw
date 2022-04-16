package com.marielagcw.service;


import com.marielagcw.model.dto.OdontologoDTO;
import com.marielagcw.model.entity.Odontologo;
import java.util.List;
import java.util.Optional;

public interface IOdontologoService {

   /* ──────────────
       MÉTODOS CRUD
     ────────────── */

    // GUARDAR
    void save(OdontologoDTO odontologoDTO);

    // BUSCAR TODOS
    List<OdontologoDTO> findAll();

    // BUSCAR POR ID
    OdontologoDTO findById(Integer id);

    // ELIMINAR POR ID
    void deleteById(Integer id);

    // MODIFICAR POR ID
    void update(OdontologoDTO odontologoDTO);

}
