package com.ceiba.destino.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoDestino;
import com.ceiba.destino.comando.manejador.ManejadorActualizarDestino;
import com.ceiba.destino.comando.manejador.ManejadorCrearDestino;
import com.ceiba.destino.comando.manejador.ManejadorEliminarDestino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/destinos")
@Api(tags = { "Controlador comando destino"})
public class ComandoControladorDestino {

    private final ManejadorCrearDestino manejadorCrearDestino;
	private final ManejadorEliminarDestino manejadorEliminarDestino;
	private final ManejadorActualizarDestino manejadorActualizarDestino;

    @Autowired
    public ComandoControladorDestino(ManejadorCrearDestino manejadorCrearDestino,
									 ManejadorEliminarDestino manejadorEliminarDestino,
									 ManejadorActualizarDestino manejadorActualizarDestino) {
        this.manejadorCrearDestino = manejadorCrearDestino;
		this.manejadorEliminarDestino = manejadorEliminarDestino;
		this.manejadorActualizarDestino = manejadorActualizarDestino;
    }

    @PostMapping
    @ApiOperation("Crear Destino")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoDestino comandoDestino) {
        return manejadorCrearDestino.ejecutar(comandoDestino);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Destino")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarDestino.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Destino")
	public void actualizar(@RequestBody ComandoDestino comandoDestino,@PathVariable Long id) {
		comandoDestino.setId(id);
		manejadorActualizarDestino.ejecutar(comandoDestino);
	}
}
