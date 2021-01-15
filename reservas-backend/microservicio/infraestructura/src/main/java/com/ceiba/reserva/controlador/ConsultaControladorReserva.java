package com.ceiba.reserva.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.ManejadorConsultarReserva;
import com.ceiba.consulta.ManejadorListarReserva;
import com.ceiba.usuario.modelo.dto.DtoReserva;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/reservas")
@Api(tags={"Controlador consulta reserva"})
public class ConsultaControladorReserva {

    private final ManejadorListarReserva manejadorListarReservas;
    private final ManejadorConsultarReserva manejadorConsultarReservas;

    public ConsultaControladorReserva(ManejadorListarReserva manejadorListarReservas, ManejadorConsultarReserva manejadorConsultarReservas) {
        this.manejadorListarReservas = manejadorListarReservas;
        this.manejadorConsultarReservas = manejadorConsultarReservas;
    }

    @GetMapping
    @ApiOperation("Listar Reservas")
    public List<DtoReserva> listar() {
        return this.manejadorListarReservas.ejecutar();
    }
    
    @GetMapping(value="/{id}")
    @ApiOperation("Consultar Reserva")
    public DtoReserva consultar(@PathVariable Long id) {
        return this.manejadorConsultarReservas.ejecutar(id);
    }

}
