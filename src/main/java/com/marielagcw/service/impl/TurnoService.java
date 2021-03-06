package com.marielagcw.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marielagcw.exception.BadRequestExceptionService;
import com.marielagcw.exception.NotFoundIdException;
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
    @Autowired
    OdontologoService odontologoService;
    @Autowired
    PacienteService pacienteService;

   /* ──────────────
     MÉTODOS CRUD
   ────────────── */

    // GUARDAR
    public TurnoDTO saveAndFlush(TurnoDTO turnoDto) {
        odontologoService.findById(turnoDto.getOdontologo().getId());
        pacienteService.findById(turnoDto.getPaciente().getId());
        Turno turnoAGuardar = mapper.convertValue(turnoDto, Turno.class);
        List<Turno> listadoDeTurnosGuardados = turnoRepository.findAll();
        for (Turno turno : listadoDeTurnosGuardados) {
            if (turnoDto.getFechaHora().equals(turno.getFechaHora())) {
                throw new BadRequestExceptionService("La fecha que intenta ingresar ya fue ocupada");
            }
        }
        turnoRepository.saveAndFlush(turnoAGuardar);
        return mapper.convertValue(turnoAGuardar, TurnoDTO.class);
    }
    /* ----------------------------------------------------------------------------- */

    // BUSCAR TODOS
    public List<TurnoDTO> findAll() {
        List<TurnoDTO> listaTurnosDto = new ArrayList<>();
        List<Turno> listaTurnos = turnoRepository.findAll();
        for (Turno turno : listaTurnos) {
            listaTurnosDto.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return listaTurnosDto;
    }
    /* ----------------------------------------------------------------------------- */

    // BUSCAR POR ID
    public TurnoDTO findById(Integer id) {
        TurnoDTO turnoEncontrado = mapper.convertValue(turnoRepository.findById(id).orElseThrow(() -> new NotFoundIdException("El Turno con ID " + id + " no fue encontrado")), TurnoDTO.class);
        return turnoEncontrado;
    }
    /* ----------------------------------------------------------------------------- */

    // ELIMINAR POR ID
    public void deleteById(Integer id) {
        turnoRepository.findById(id).orElseThrow(() -> new NotFoundIdException("El Turno con ID " + id + " no fue encontrado y no pudo eliminarse"));
        turnoRepository.deleteById(id);
    }
    /* ----------------------------------------------------------------------------- */

    // MODIFICAR POR ID
    public void update(TurnoDTO turnoDto) {
        Turno turnoModificar = mapper.convertValue(turnoDto, Turno.class);
        turnoRepository.saveAndFlush(turnoModificar);
    }
    /* ----------------------------------------------------------------------------- */

}
