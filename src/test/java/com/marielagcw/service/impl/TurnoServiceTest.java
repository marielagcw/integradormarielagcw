package com.marielagcw.service.impl;

import com.marielagcw.exception.BadRequestExceptionService;
import com.marielagcw.model.dto.OdontologoDTO;
import com.marielagcw.model.dto.PacienteDTO;
import com.marielagcw.model.dto.TurnoDTO;
import com.marielagcw.model.entity.Domicilio;
import com.marielagcw.service.IOdontologoService;
import com.marielagcw.service.IPacienteService;
import com.marielagcw.service.ITurnoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;


@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class TurnoServiceTest {

    @Autowired
    ITurnoService turnoService;
    @Autowired
    IOdontologoService odontologoService;
    @Autowired
    IPacienteService pacienteService;

    @Test
    void _1_testGuardarTurno() throws BadRequestExceptionService {
        // DADOS
        OdontologoDTO odontologoDTO1 = new OdontologoDTO();
        odontologoDTO1.setNombre("OdontologoNombre1");
        odontologoDTO1.setApellido("OdontologoApellido1");
        odontologoService.save(odontologoDTO1);
        odontologoDTO1.setId(1);

        PacienteDTO pacienteDTO1 = new PacienteDTO();
        pacienteDTO1.setNombre("PacienteNombre1");
        pacienteDTO1.setApellido("PacienteApellido1");
        pacienteService.save(pacienteDTO1);
        pacienteDTO1.setId(1);

        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setOdontologo((odontologoDTO1));
        turnoDTO.setPaciente(pacienteDTO1);
        turnoDTO.setFechaHora(LocalDateTime.of(2022, Month.JUNE, 8, 12, 30));
        turnoDTO.setId(1);

        // CUANDO
        turnoService.save(turnoDTO);
        TurnoDTO resultadoEsperado = turnoService.findById(1);

        // ENTONCES
        Assertions.assertTrue(resultadoEsperado != null);

    }

    @Test
    void _2_testBuscarTurnoPorId() throws BadRequestExceptionService {
        // DADOS
        OdontologoDTO odontologoDTO2 = new OdontologoDTO();
        odontologoDTO2.setNombre("OdontologoNombre2");
        odontologoDTO2.setApellido("OdontologoApellido2");
        odontologoService.save(odontologoDTO2);
        odontologoDTO2.setId(2);

        PacienteDTO pacienteDTO2 = new PacienteDTO();
        pacienteDTO2.setNombre("PacienteNombre2");
        pacienteDTO2.setApellido("PacienteApellido2");
        pacienteDTO2.setDomicilio(new Domicilio());
        pacienteService.save(pacienteDTO2);
        pacienteDTO2.setId(2);

        TurnoDTO turnoDTO1 = new TurnoDTO();
        turnoDTO1.setOdontologo((odontologoDTO2));
        turnoDTO1.setPaciente(pacienteDTO2);
        turnoDTO1.setFechaHora(LocalDateTime.of(2022, Month.JUNE, 9, 12, 30));
        turnoService.save(turnoDTO1);
        turnoDTO1.setId(2);

        // CUANDO
        TurnoDTO resultadoEsperado2 = turnoService.findById(2);

        // ENTONCES
        Assertions.assertTrue(resultadoEsperado2 != null);
    }

    @Test
    void _3_BuscarTodosLosTurnos() throws BadRequestExceptionService {
        // DADOS
        OdontologoDTO odontologoDTO3 = new OdontologoDTO();
        odontologoDTO3.setNombre("OdontologoNombre3");
        odontologoDTO3.setApellido("OdontologoApellido3");
        odontologoService.save(odontologoDTO3);
        odontologoDTO3.setId(3);



        PacienteDTO pacienteDTO3 = new PacienteDTO();
        pacienteDTO3.setNombre("PacienteNombre3");
        pacienteDTO3.setApellido("PacienteApellido3");
        pacienteService.save(pacienteDTO3);
        pacienteDTO3.setId(3);

        TurnoDTO turnoDTO2 = new TurnoDTO();
        turnoDTO2.setOdontologo((odontologoDTO3));
        turnoDTO2.setPaciente(pacienteDTO3);
        turnoDTO2.setFechaHora(LocalDateTime.of(2022, Month.JUNE, 10, 12, 30));
        turnoService.save(turnoDTO2);
        turnoDTO2.setId(3);

        // CUANDO
        List<TurnoDTO> listaTurnosEncontrados = turnoService.findAll();

        // ENTONCES
        Assertions.assertTrue(listaTurnosEncontrados.size() > 0);
    }

    @Test
    void _4_testEliminarTurno() throws BadRequestExceptionService {
        // DADOS
        OdontologoDTO odontologoDTO4 = new OdontologoDTO();
        odontologoDTO4.setNombre("OdontologoNombre4");
        odontologoDTO4.setApellido("OdontologoApellido4");
        odontologoService.save(odontologoDTO4);
        odontologoDTO4.setId(4);

        PacienteDTO pacienteDTO4 = new PacienteDTO();
        pacienteDTO4.setNombre("PacienteNombre4");
        pacienteDTO4.setApellido("PacienteApellido4");
        pacienteService.save(pacienteDTO4);
        pacienteDTO4.setId(4);

        TurnoDTO turnoDTO3 = new TurnoDTO();
        turnoDTO3.setOdontologo((odontologoDTO4));
        turnoDTO3.setPaciente(pacienteDTO4);
        turnoDTO3.setFechaHora(LocalDateTime.of(2022, Month.JUNE, 11, 12, 30));
        turnoService.save(turnoDTO3);
        turnoDTO3.setId(4);

        // CUANDO
        turnoService.deleteById(4);
        TurnoDTO resultadoEsperado3 = turnoService.findById(4);

        // ENTONCES
        Assertions.assertTrue(resultadoEsperado3 == null);
    }


    @Test
    void _5_testModificarTurno() throws BadRequestExceptionService {
        // DADOS
        OdontologoDTO odontologoDTO5 = new OdontologoDTO();
        odontologoDTO5.setNombre("OdontologoNombre5");
        odontologoDTO5.setApellido("OdontologoApellido5");
        odontologoService.save(odontologoDTO5);
        odontologoDTO5.setId(5);

        PacienteDTO pacienteDTO5 = new PacienteDTO();
        pacienteDTO5.setNombre("PacienteNombre5");
        pacienteDTO5.setApellido("PacienteApellido5");
        pacienteService.save(pacienteDTO5);
        pacienteDTO5.setId(5);

        TurnoDTO turnoDTO4 = new TurnoDTO();
        turnoDTO4.setOdontologo((odontologoDTO5));
        turnoDTO4.setPaciente(pacienteDTO5);
        turnoDTO4.setFechaHora(LocalDateTime.of(2022, Month.JUNE, 12, 12, 30));
        turnoService.save(turnoDTO4);
        turnoDTO4.setId(5);


        //turnoModificado.setFechaHora(LocalDateTime.of(2023,Month.JUNE, 13,20,30));

        // CUANDO
        turnoService.deleteById(4);
        TurnoDTO resultadoEsperado3 = turnoService.findById(4);

        // ENTONCES
        Assertions.assertTrue(resultadoEsperado3 == null);
    }
}