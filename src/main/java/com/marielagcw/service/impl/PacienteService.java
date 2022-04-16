package com.marielagcw.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marielagcw.model.dto.PacienteDTO;
import com.marielagcw.model.entity.Paciente;
import com.marielagcw.repository.IPacienteRepository;
import com.marielagcw.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

   /* ──────────────
     MÉTODOS CRUD
   ────────────── */

    // GUARDAR
    public void save(PacienteDTO pacienteDTO) {
        Paciente pacienteAGuardar = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(pacienteAGuardar);
    }
    /* ----------------------------------------------------------------------------- */

    // BUSCAR TODOS
    public List<PacienteDTO> findAll() {
        List<PacienteDTO> listaPacientesDTO = new ArrayList<>();
        List<Paciente> listaPacientes = pacienteRepository.findAll();
        for (Paciente paciente : listaPacientes) {
            listaPacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return listaPacientesDTO;
    }
    /* ----------------------------------------------------------------------------- */

    // BUSCAR POR ID
    public PacienteDTO findById(Integer id) {
        PacienteDTO pacienteEncontrado = mapper.convertValue(pacienteRepository.findById(id), PacienteDTO.class);
        return pacienteEncontrado;
    }
    /* ----------------------------------------------------------------------------- */

    // ELIMINAR POR ID
    public void deleteById(Integer id) {
        pacienteRepository.deleteById(id);
    }
    /* ----------------------------------------------------------------------------- */

    // MODIFICAR POR ID
    public void update(PacienteDTO pacienteDTO) {
        Paciente pacienteModificar = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(pacienteModificar);
    }
    /* ----------------------------------------------------------------------------- */
}
