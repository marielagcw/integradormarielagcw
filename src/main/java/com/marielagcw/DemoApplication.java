package com.marielagcw;

import com.marielagcw.model.dto.OdontologoDTO;
import com.marielagcw.service.impl.OdontologoService;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        PropertyConfigurator.configure("log4j.properties");
        SpringApplication.run(DemoApplication.class, args);


    }

}
