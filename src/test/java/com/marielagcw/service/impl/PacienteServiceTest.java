package com.marielagcw.service.impl;

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
        pacienteService.save(pacienteDTO);
        PacienteDTO resultadoEsperado1 = pacienteService.findById(1);

        // ENTONCES
        Assertions.assertTrue(resultadoEsperado1 != null);
    }

    @Test
    void _2_testBuscarPaciente() {
        // DADOS
        PacienteDTO pacienteDTO2 = new PacienteDTO();
        pacienteDTO2.setNombre("PacienteNombre2");
        pacienteDTO2.setApellido("PacienteApellido2");
        pacienteService.save(pacienteDTO2);

        // CUANDO
        PacienteDTO resultadoEsperado2 = pacienteService.findById(2);
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
        pacienteService.save(pacienteDTO5);

        // CUANDO
        pacienteService.deleteById(1);
        PacienteDTO resultadoEsperado3 = pacienteService.findById(1);

        // ENTONCES
        Assertions.assertTrue(resultadoEsperado3 == null);
    }

    @Test
    public void _5_testModificarPaciente() {
        // DADOS
        PacienteDTO pacienteDTO6 = new PacienteDTO();
        pacienteDTO6.setNombre("PacienteNombre6");
        pacienteDTO6.setApellido("PacienteApellido6");
        pacienteService.save(pacienteDTO6);
        PacienteDTO pacienteModificado = new PacienteDTO();
        pacienteModificado.setId(2);
        pacienteModificado.setNombre("PacienteModificadoNombre");
        pacienteModificado.setApellido("PacienteModificadoApellido");

        // CUANDO
        pacienteService.update(pacienteModificado);
        PacienteDTO resultadoEsperado4 = pacienteService.findById(2);

        // ENTONCES
        Assertions.assertTrue(resultadoEsperado4.getApellido().equals(pacienteModificado.getApellido()));
    }

}