package com.ceiba.vuelo.controlador;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.flywaydb.core.Flyway;

import com.ceiba.ApplicationMock;
import com.ceiba.reserva.controlador.ConsultaControladorReserva;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorReserva.class)
public class ConsultaControladorVueloTest {

    @Autowired
    private MockMvc mocMvc;
    
    @Autowired
    private Flyway flyway;
    
    @Before
    public void before() {
        flyway.clean();
        flyway.migrate();
    }
    
    @After
    public void after() {
        flyway.clean();
    }
    
    @Test
    public void consultarPorCiudadOrigenYCiudadDestinoYFechaTest() throws Exception {
        // arrange
    	String ciudadOrigen = "pereira";
    	String ciudadDestino = "medellin";
    	String fecha = "2020-12-01";
        // act - assert
        mocMvc.perform(get("/vuelos/{ciudadOrigen}/{ciudadDestino}/{fecha}/", ciudadOrigen, ciudadDestino, fecha)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].ciudadOrigen", is("pereira")));
    }

}
