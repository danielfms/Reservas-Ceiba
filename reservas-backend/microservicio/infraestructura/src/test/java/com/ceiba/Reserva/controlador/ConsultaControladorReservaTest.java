package com.ceiba.Reserva.controlador;

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
public class ConsultaControladorReservaTest {

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
    public void listar() throws Exception {
        // arrange

        // act - assert
        mocMvc.perform(get("/reservas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].token", is("TOKEN")));
    }
        
    @Test
    public void consultar() throws Exception {
        // arrange
    	Long id = 1L;
        // act - assert
        mocMvc.perform(get("/reservas/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tipoIdentificacion", is("CC")))
                .andExpect(jsonPath("$.numeroIdentificacion", is("12378444554")));
        
    }

}
