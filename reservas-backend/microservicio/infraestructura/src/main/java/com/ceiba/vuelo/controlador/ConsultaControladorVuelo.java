package com.ceiba.vuelo.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.usuario.modelo.dto.DtoVuelo;
import com.ceiba.vuelo.consulta.ManejadorListarVuelo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/vuelos")
@Api(tags={"Controlador consulta vuelo"})
@CrossOrigin(origins = "http://40.76.168.121")
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
    
    
    @GetMapping("/{ciudadOrigen}/{ciudadDestino}/{fecha}")
    @ApiOperation("Listar Vuelos con filtros")
    public List<DtoVuelo> listarConFiltros(@PathVariable String ciudadOrigen, @PathVariable String ciudadDestino,
    		@PathVariable String fecha) {
        return this.manejadorListarVuelos.ejecutar(ciudadOrigen, ciudadDestino, fecha);
    }
    
    @GetMapping("/{id}")
    @ApiOperation("Listar Vuelos con filtros")
    public DtoVuelo listarConFiltros(@PathVariable Long id) {
        return this.manejadorListarVuelos.ejecutar(id);
    }
    
}
