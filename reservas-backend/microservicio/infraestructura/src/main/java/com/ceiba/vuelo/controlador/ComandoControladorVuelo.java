package com.ceiba.vuelo.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoVuelo;
import com.ceiba.vuelo.comando.manejador.ManejadorActualizarVuelo;
import com.ceiba.vuelo.comando.manejador.ManejadorCrearVuelo;
import com.ceiba.vuelo.comando.manejador.ManejadorEliminarVuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/vuelos")
@Api(tags = { "Controlador comando vuelo"})
@CrossOrigin(origins = "http://40.76.168.121")
public class ComandoControladorVuelo {

    private final ManejadorCrearVuelo manejadorCrearVuelo;
	private final ManejadorEliminarVuelo manejadorEliminarVuelo;
	private final ManejadorActualizarVuelo manejadorActualizarVuelo;

    @Autowired
    public ComandoControladorVuelo(ManejadorCrearVuelo manejadorCrearVuelo,
									 ManejadorEliminarVuelo manejadorEliminarVuelo,
									 ManejadorActualizarVuelo manejadorActualizarVuelo) {
        this.manejadorCrearVuelo = manejadorCrearVuelo;
		this.manejadorEliminarVuelo = manejadorEliminarVuelo;
		this.manejadorActualizarVuelo = manejadorActualizarVuelo;
    }

    @PostMapping
    @ApiOperation("Crear Vuelo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoVuelo comandoVuelo) {
        return manejadorCrearVuelo.ejecutar(comandoVuelo);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Vuelo")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarVuelo.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Vuelo")
	public void actualizar(@RequestBody ComandoVuelo comandoVuelo,@PathVariable Long id) {
		comandoVuelo.setId(id);
		manejadorActualizarVuelo.ejecutar(comandoVuelo);
	}
}
