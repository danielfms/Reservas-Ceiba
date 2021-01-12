package com.ceiba.avion.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.avion.comando.manejador.ManejadorActualizarAvion;
import com.ceiba.avion.comando.manejador.ManejadorCrearAvion;
import com.ceiba.avion.comando.manejador.ManejadorEliminarAvion;
import com.ceiba.usuario.comando.ComandoAvion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/aviones")
@Api(tags = { "Controlador comando avion"})
public class ComandoControladorAvion {

    private final ManejadorCrearAvion manejadorCrearAvion;
	private final ManejadorEliminarAvion manejadorEliminarAvion;
	private final ManejadorActualizarAvion manejadorActualizarAvion;

    @Autowired
    public ComandoControladorAvion(ManejadorCrearAvion manejadorCrearAvion,
									 ManejadorEliminarAvion manejadorEliminarAvion,
									 ManejadorActualizarAvion manejadorActualizarAvion) {
        this.manejadorCrearAvion = manejadorCrearAvion;
		this.manejadorEliminarAvion = manejadorEliminarAvion;
		this.manejadorActualizarAvion = manejadorActualizarAvion;
    }

    @PostMapping
    @ApiOperation("Crear Avion")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoAvion comandoAvion) {
        return manejadorCrearAvion.ejecutar(comandoAvion);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Avion")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarAvion.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Avion")
	public void actualizar(@RequestBody ComandoAvion comandoAvion,@PathVariable Long id) {
		comandoAvion.setId(id);
		manejadorActualizarAvion.ejecutar(comandoAvion);
	}
}
