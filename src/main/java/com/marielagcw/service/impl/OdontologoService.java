package com.marielagcw.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marielagcw.model.dto.OdontologoDTO;
import com.marielagcw.model.entity.Odontologo;
import com.marielagcw.repository.IOdontologoRepository;
import com.marielagcw.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OdontologoService implements IOdontologoService{

    @Autowired
    IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

   /* ──────────────
     MÉTODOS CRUD
   ────────────── */

    // GUARDAR
    public void save(OdontologoDTO odontologoDTO) {
        Odontologo odontologoAGuardar = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologoAGuardar);
    }
    /* ----------------------------------------------------------------------------- */

    // BUSCAR TODOS
    public List<OdontologoDTO> findAll() {
        List<OdontologoDTO> listaOdontologosDTO = new ArrayList<>();
        List<Odontologo> listaOdontologos = odontologoRepository.findAll();
        for (Odontologo odontologo : listaOdontologos) {
            listaOdontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return listaOdontologosDTO;
    }
    /* ----------------------------------------------------------------------------- */

    // BUSCAR POR ID
    public OdontologoDTO findById(Integer id) {
        OdontologoDTO odontologoEncontrado = mapper.convertValue(odontologoRepository.findById(id), OdontologoDTO.class);
       return odontologoEncontrado;
    }
    /* ----------------------------------------------------------------------------- */

    // ELIMINAR POR ID
    public void deleteById(Integer id) {
        odontologoRepository.deleteById(id);
    }
    /* ----------------------------------------------------------------------------- */

    // MODIFICAR POR ID
    public void update(OdontologoDTO odontologoDTO) {
        Odontologo odontologoModificar = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.saveAndFlush(odontologoModificar);
    }
    /* ----------------------------------------------------------------------------- */
    
}
