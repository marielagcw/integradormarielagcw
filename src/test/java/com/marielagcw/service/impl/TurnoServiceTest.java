package com.marielagcw.service.impl;

import com.marielagcw.service.ITurnoService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class TurnoServiceTest {

    @Autowired
    ITurnoService turnoService;

    @Test
    void _1_testGuardarTurno() {
    }

    @Test
    void _2_testBuscarTodosLosTurnos() {
    }

    @Test
    void _3_BuscarTurnoPorId() {
    }

    @Test
    void _4_testEliminarTurno() {
    }

    @Test
    void _5_testModificarTurno() {
    }
}