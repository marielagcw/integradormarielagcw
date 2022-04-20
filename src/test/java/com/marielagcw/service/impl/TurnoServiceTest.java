package com.marielagcw.service.impl;

import com.marielagcw.exception.BadRequestExceptionService;
import com.marielagcw.exception.NotFoundIdException;
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
    void _1_testGuardarTurno(){
        // DADOS
        OdontologoDTO odontologoDTO1 = new OdontologoDTO();
        odontologoDTO1.setNombre("OdontologoNombre1");
        odontologoDTO1.setApellido("OdontologoApellido1");
        odontologoDTO1 = odontologoService.save(odontologoDTO1);

        PacienteDTO pacienteDTO1 = new PacienteDTO();
        pacienteDTO1.setNombre("PacienteNombre1");
        pacienteDTO1.setApellido("PacienteApellido1");
        pacienteDTO1 = pacienteService.save(pacienteDTO1);

        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setOdontologo(odontologoDTO1);
        turnoDTO.setPaciente(pacienteDTO1);
        turnoDTO.setFechaHora(LocalDateTime.of(2022, Month.JUNE, 8, 12, 30));

        // CUANDO
       turnoDTO = turnoService.save(turnoDTO);
        TurnoDTO resultadoEsperado = turnoService.findById(turnoDTO.getId());

        // ENTONCES
        Assertions.assertTrue(resultadoEsperado != null);

    }

    @Test
    void _2_testBuscarTurnoPorId() throws BadRequestExceptionService {
        // DADOS
        OdontologoDTO odontologoDTO2 = new OdontologoDTO();
        odontologoDTO2.setNombre("OdontologoNombre2");
        odontologoDTO2.setApellido("OdontologoApellido2");
        odontologoDTO2 = odontologoService.save(odontologoDTO2);

        PacienteDTO pacienteDTO2 = new PacienteDTO();
        pacienteDTO2.setNombre("PacienteNombre2");
        pacienteDTO2.setApellido("PacienteApellido2");
        pacienteDTO2.setDomicilio(new Domicilio());
        pacienteDTO2 = pacienteService.save(pacienteDTO2);

        TurnoDTO turnoDTO1 = new TurnoDTO();
        turnoDTO1.setOdontologo((odontologoDTO2));
        turnoDTO1.setPaciente(pacienteDTO2);
        turnoDTO1.setFechaHora(LocalDateTime.of(2022, Month.JUNE, 9, 12, 30));
        turnoDTO1 = turnoService.save(turnoDTO1);

        // CUANDO
        TurnoDTO resultadoEsperado2 = turnoService.findById(turnoDTO1.getId());

        // ENTONCES
        Assertions.assertTrue(resultadoEsperado2 != null);
    }

    @Test
    void _3_BuscarTodosLosTurnos() throws BadRequestExceptionService {
        // DADOS
        OdontologoDTO odontologoDTO3 = new OdontologoDTO();
        odontologoDTO3.setNombre("OdontologoNombre3");
        odontologoDTO3.setApellido("OdontologoApellido3");
        odontologoDTO3 = odontologoService.save(odontologoDTO3);


        PacienteDTO pacienteDTO3 = new PacienteDTO();
        pacienteDTO3.setNombre("PacienteNombre3");
        pacienteDTO3.setApellido("PacienteApellido3");
        pacienteDTO3 = pacienteService.save(pacienteDTO3);

        TurnoDTO turnoDTO2 = new TurnoDTO();
        turnoDTO2.setOdontologo((odontologoDTO3));
        turnoDTO2.setPaciente(pacienteDTO3);
        turnoDTO2.setFechaHora(LocalDateTime.of(2022, Month.JUNE, 10, 12, 30));
        turnoService.save(turnoDTO2);

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
        odontologoDTO4 = odontologoService.save(odontologoDTO4);

        PacienteDTO pacienteDTO4 = new PacienteDTO();
        pacienteDTO4.setNombre("PacienteNombre4");
        pacienteDTO4.setApellido("PacienteApellido4");
        pacienteDTO4 = pacienteService.save(pacienteDTO4);


        TurnoDTO turnoDTO3 = new TurnoDTO();
        turnoDTO3.setOdontologo((odontologoDTO4));
        turnoDTO3.setPaciente(pacienteDTO4);
        turnoDTO3.setFechaHora(LocalDateTime.of(2022, Month.JUNE, 11, 12, 30));
        turnoDTO3 = turnoService.save(turnoDTO3);
        Integer idEliminado = turnoDTO3.getId();

        // CUANDO
        turnoService.deleteById(turnoDTO3.getId());

        // ENTONCES
        Assertions.assertThrows(NotFoundIdException.class, ()-> turnoService.findById(idEliminado));
    }


    @Test
    void _5_testModificarTurno() {
// DADOS
        OdontologoDTO odontologoDTO5 = new OdontologoDTO();
        odontologoDTO5.setNombre("OdontologoNombre5");
        odontologoDTO5.setApellido("OdontologoApellido5");
        odontologoDTO5 = odontologoService.save(odontologoDTO5);

        PacienteDTO pacienteDTO5 = new PacienteDTO();
        pacienteDTO5.setNombre("PacienteNombre5");
        pacienteDTO5.setApellido("PacienteApellido5");
        pacienteDTO5.setDomicilio(new Domicilio());
        pacienteDTO5 = pacienteService.save(pacienteDTO5);

        TurnoDTO turnoDTO4 = new TurnoDTO();
        turnoDTO4.setOdontologo((odontologoDTO5));
        turnoDTO4.setPaciente(pacienteDTO5);
        turnoDTO4.setFechaHora(LocalDateTime.of(2022, Month.JUNE, 19, 12, 30));
        turnoDTO4 = turnoService.save(turnoDTO4);
        turnoDTO4.setFechaHora(LocalDateTime.of(2023, Month.JUNE, 19, 12, 30));

        // CUANDO
        turnoService.update(turnoDTO4);
        TurnoDTO resultadoEsperado3 = turnoService.findById(turnoDTO4.getId());

        // ENTONCES
        Assertions.assertTrue(resultadoEsperado3.getFechaHora().equals(turnoDTO4.getFechaHora()));

    }
}