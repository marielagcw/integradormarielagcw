package com.marielagcw.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marielagcw.model.dto.TurnoDTO;
import com.marielagcw.model.entity.Turno;
import com.marielagcw.repository.ITurnoRepository;
import com.marielagcw.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    ITurnoRepository turnoRepository;
    @Autowired
    ObjectMapper mapper;

   /* ──────────────
     MÉTODOS CRUD
   ────────────── */

    // GUARDAR
    public void save(TurnoDTO turnoDto) {
        Turno turnoAGuardar = mapper.convertValue(turnoDto, Turno.class);
        turnoRepository.save(turnoAGuardar);
    }
    /* ----------------------------------------------------------------------------- */

    // BUSCAR TODOS
    public List<TurnoDTO> findAll() {
        List<TurnoDTO> listaTurnosDto = new ArrayList<>();
        List<Turno> listaTurnos = turnoRepository.findAll(); // findAll del JPA
        for (Turno turno : listaTurnos) {
            listaTurnosDto.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return listaTurnosDto;
    }
    /* ----------------------------------------------------------------------------- */

    // BUSCAR POR ID
    public TurnoDTO findById(Integer id) {
        TurnoDTO turnoEncontrado = mapper.convertValue(turnoRepository.findById(id), TurnoDTO.class);
        return turnoEncontrado;
    }
    /* ----------------------------------------------------------------------------- */

    // ELIMINAR POR ID
    public void deleteById(Integer id) {
        turnoRepository.deleteById(id);
    }
    /* ----------------------------------------------------------------------------- */

    // MODIFICAR POR ID
    public void update(TurnoDTO turnoDto) {
        Turno turnoModificar = mapper.convertValue(turnoDto, Turno.class);
        turnoRepository.save(turnoModificar);
    }
    /* ----------------------------------------------------------------------------- */

}
