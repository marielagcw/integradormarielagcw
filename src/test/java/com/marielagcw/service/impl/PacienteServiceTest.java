package com.marielagcw.service.impl;

import com.marielagcw.exception.NotFoundIdException;
import com.marielagcw.model.dto.PacienteDTO;
import com.marielagcw.service.IPacienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PacienteServiceTest {

    @Autowired
    IPacienteService pacienteService;

    @Test
    void _1_testCrearPaciente() {
        // DADOS
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("PacienteNombre1");
        pacienteDTO.setApellido("PacienteApellido1");

        // CUANDO
       pacienteDTO =  pacienteService.save(pacienteDTO);
        PacienteDTO resultadoEsperado1 = pacienteService.findById(pacienteDTO.getId());

        // ENTONCES
        Assertions.assertTrue(resultadoEsperado1 != null);
    }

    @Test
    void _2_testBuscarPacientePorId() {
        // DADOS
        PacienteDTO pacienteDTO2 = new PacienteDTO();
        pacienteDTO2.setNombre("PacienteNombre2");
        pacienteDTO2.setApellido("PacienteApellido2");
       pacienteDTO2 = pacienteService.save(pacienteDTO2);

        // CUANDO
        PacienteDTO resultadoEsperado2 = pacienteService.findById(pacienteDTO2.getId());
        // ENTONCES
        Assertions.assertTrue(resultadoEsperado2 != null);
    }

    @Test
    public void _3_testBuscarTodosLosPacientes() {
        // DADOS
        PacienteDTO pacienteDTO3 = new PacienteDTO();
        pacienteDTO3.setNombre("PacienteNombre3");
        pacienteDTO3.setApellido("PacienteApellido3");
        pacienteService.save(pacienteDTO3);

        PacienteDTO pacienteDTO4 = new PacienteDTO();
        pacienteDTO4.setNombre("PacienteNombre4");
        pacienteDTO4.setApellido("PacienteApellido4");
        pacienteService.save(pacienteDTO4);

        // CUANDO
        List<PacienteDTO> listaPacientesEncontrados = pacienteService.findAll();

        // ENTONCES
        Assertions.assertTrue(listaPacientesEncontrados.size() > 0);

    }

    @Test
    public void _4_testEliminarPaciente() {
        // DADOS
        PacienteDTO pacienteDTO5 = new PacienteDTO();
        pacienteDTO5.setNombre("PacienteNombre5");
        pacienteDTO5.setApellido("PacienteApellido5");
        pacienteDTO5 = pacienteService.save(pacienteDTO5);
        Integer idEliminado = pacienteDTO5.getId();

        // CUANDO
        pacienteService.deleteById(pacienteDTO5.getId());

        // ENTONCES
        Assertions.assertThrows(NotFoundIdException.class, ()-> pacienteService.findById(idEliminado));
    }

    @Test
    public void _5_testModificarPaciente() {
        // DADOS
        PacienteDTO pacienteDTO6 = new PacienteDTO();
        pacienteDTO6.setNombre("PacienteNombre6");
        pacienteDTO6.setApellido("PacienteApellido6");
        pacienteDTO6 = pacienteService.save(pacienteDTO6);
        pacienteDTO6.setApellido("OtroApellido");

        // CUANDO
        pacienteService.update(pacienteDTO6);
        PacienteDTO resultadoEsperado4 = pacienteService.findById(pacienteDTO6.getId());

        // ENTONCES
        Assertions.assertTrue(resultadoEsperado4.getApellido().equals(pacienteDTO6.getApellido()));
    }

}