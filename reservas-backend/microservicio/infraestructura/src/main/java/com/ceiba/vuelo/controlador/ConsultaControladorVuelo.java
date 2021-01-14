package com.ceiba.vuelo.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.ManejadorListarVuelo;
import com.ceiba.usuario.modelo.dto.DtoVuelo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/vuelos")
@Api(tags={"Controlador consulta vuelo"})
public class ConsultaControladorVuelo {

    private final ManejadorListarVuelo manejadorListarVuelos;

    public ConsultaControladorVuelo(ManejadorListarVuelo manejadorListarVuelos) {
        this.manejadorListarVuelos = manejadorListarVuelos;
    }

    @GetMapping
    @ApiOperation("Listar Vuelos")
    public List<DtoVuelo> listar() {
        return this.manejadorListarVuelos.ejecutar();
    }

}
