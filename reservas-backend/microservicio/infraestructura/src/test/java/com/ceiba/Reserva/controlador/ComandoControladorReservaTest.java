package com.ceiba.Reserva.controlador;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.flywaydb.core.Flyway;

import com.ceiba.ApplicationMock;
import com.ceiba.comando.ComandoReserva;
import com.ceiba.reserva.controlador.ComandoControladorReserva;
import com.ceiba.usuario.servicio.testdatabuilder.ComandoReservaTestDataBuilder;

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
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorReserva.class)
public class ComandoControladorReservaTest {

    @Autowired
    private ObjectMapper objectMapper;

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
    public void crear() throws Exception{
        // arrange
        ComandoReserva reserva = new ComandoReservaTestDataBuilder()
        		.conTipoIdentificacion("TI")
        		.conNumeroIdentificacion("9999999999")
        		.build();

        // act - assert
        mocMvc.perform(post("/reservas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reserva)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    public void actualizar() throws Exception{
        // arrange
        Long id = 1L;
        ComandoReserva reserva = new ComandoReservaTestDataBuilder()
        		.conToken("ABCDF").build();

        
        // act - assert
        mocMvc.perform(put("/reservas/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reserva)))
                .andExpect(status().isOk());
        
        //Validar que el registro fue efectivamente modificado
        mocMvc.perform(get("/reservas/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token", is("ABCDF")));
        
        
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 1L;

        // act - assert
        mocMvc.perform(delete("/reservas/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        
        mocMvc.perform(get("/reservas/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
