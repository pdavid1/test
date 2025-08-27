package com.test.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class EjemploControlador {

    private final EjemploService ejemploService;
    @Autowired
    private final EjemploVersion ejemploVersion;

    public EjemploControlador(EjemploService ejemploService, EjemploVersion ejemploVersion) {
        this.ejemploService = ejemploService;
        this.ejemploVersion = ejemploVersion;
    }



}
