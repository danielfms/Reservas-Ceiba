package com.ceiba.destino.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.ManejadorListarDestino;
import com.ceiba.usuario.modelo.dto.DtoDestino;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/destinos")
@Api(tags={"Controlador consulta usuario"})
public class ConsultaControladorDestino {

    private final ManejadorListarDestino manejadorListarDestinos;

    public ConsultaControladorDestino(ManejadorListarDestino manejadorListarDestinos) {
        this.manejadorListarDestinos = manejadorListarDestinos;
    }

    @GetMapping
    @ApiOperation("Listar Destinos")
    public List<DtoDestino> listar() {
        return this.manejadorListarDestinos.ejecutar();
    }

}
