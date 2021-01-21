package com.ceiba.avion.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.ManejadorListarAvion;
import com.ceiba.usuario.modelo.dto.DtoAvion;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/aviones")
@Api(tags={"Controlador consulta avion"})
@CrossOrigin(origins = "http://localhost:4200")
public class ConsultaControladorAvion {

    private final ManejadorListarAvion manejadorListarAvion;

    public ConsultaControladorAvion(ManejadorListarAvion manejadorListarAvions) {
        this.manejadorListarAvion = manejadorListarAvions;
    }

    @GetMapping
    @ApiOperation("Listar Aviones")
    public List<DtoAvion> listar() {
        return this.manejadorListarAvion.ejecutar();
    }

}
