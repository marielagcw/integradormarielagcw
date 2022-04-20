package com.marielagcw.service.impl;

import com.marielagcw.exception.NotFoundIdException;
import com.marielagcw.model.dto.OdontologoDTO;
import com.marielagcw.service.IOdontologoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class OdontologoServiceTest {

    @Autowired
    IOdontologoService odontologoService;

    @Test
    public void _1_testCrearOdontologo() {
        // DADOS
        OdontologoDTO odontologoDTO1 = new OdontologoDTO();
        odontologoDTO1.setNombre("OdontologoNombre1");
        odontologoDTO1.setApellido("OdontologoApellido1");

        // CUANDO
        odontologoDTO1 = odontologoService.save(odontologoDTO1);
        OdontologoDTO resultadoEsperado1 = odontologoService.findById(odontologoDTO1.getId());

        // ENTONCES
        Assertions.assertTrue(resultadoEsperado1 != null);
    }

    @Test
    public void _2_testBuscarOdontologoPorId() {
        // DADOS
        OdontologoDTO odontologoDTO2 = new OdontologoDTO();
        odontologoDTO2.setNombre("OdontologoNombre2");
        odontologoDTO2.setApellido("OdontologoApellido2");
        odontologoDTO2 = odontologoService.save(odontologoDTO2);


        // CUANDO
        OdontologoDTO resultadoEsperado2 = odontologoService.findById(odontologoDTO2.getId());

        // ENTONCES
        Assertions.assertTrue(resultadoEsperado2 != null);

    }

    @Test
    public void _3_testBuscarTodosLosOdontologos() {
        // DADOS
        OdontologoDTO odontologoDTO3 = new OdontologoDTO();
        odontologoDTO3.setNombre("OdontologoNombre3");
        odontologoDTO3.setApellido("OdontologoApellido3");
        odontologoService.save(odontologoDTO3);

        OdontologoDTO odontologoDTO4 = new OdontologoDTO();
        odontologoDTO4.setNombre("OdontologoNombre4");
        odontologoDTO4.setApellido("OdontologoApellido4");
        odontologoService.save(odontologoDTO4);

        // CUANDO
        List<OdontologoDTO> listaOdontologosEncontrados = odontologoService.findAll();

        // ENTONCES
        Assertions.assertTrue(listaOdontologosEncontrados.size() > 0);

    }

    @Test
    public void _4_testEliminarOdontologo() {
        // DADOS
        OdontologoDTO odontologoDTO5 = new OdontologoDTO();
        odontologoDTO5.setNombre("OdontologoNombre5");
        odontologoDTO5.setApellido("OdontologoApellido5");
        odontologoDTO5 = odontologoService.save(odontologoDTO5);
        Integer idEliminado = odontologoDTO5.getId();

        // CUANDO
        odontologoService.deleteById(odontologoDTO5.getId());

        // ENTONCES
        Assertions.assertThrows(NotFoundIdException.class, ()-> odontologoService.findById(idEliminado));
    }

    @Test
    public void _5_testModificarOdontologo() {
        // DADOS
        OdontologoDTO odontologoDTO6 = new OdontologoDTO();
        odontologoDTO6.setNombre("OdontologoNombre6");
        odontologoDTO6.setApellido("OdontologoApellido6");
        odontologoDTO6 = odontologoService.save(odontologoDTO6);
        odontologoDTO6.setApellido("OtroApellido");


        // CUANDO
        odontologoService.update(odontologoDTO6);
        OdontologoDTO resultadoEsperado4 = odontologoService.findById(odontologoDTO6.getId());

        // ENTONCES
        Assertions.assertTrue(resultadoEsperado4.getApellido().equals(odontologoDTO6.getApellido()));
    }

}