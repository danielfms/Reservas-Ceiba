package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;
import static com.ceiba.dominio.ValidadorArgumento.validarIgual;
import static com.ceiba.dominio.ValidadorArgumento.validarLongitudMinima;
import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
public class Reserva {
	
    private static final String SE_DEBE_INGRESAR_EL_TIPO_IDENTIFICACION = "Se debe ingresar el tipo identificacion";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_IDENTIFICACION = "Se debe ingresar el numero identificacion";
    private static final String EL_NUMERO_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "El tipo identificacion debe tener una longitud mayor o igual a %s";
    private static final String EL_VALOR_TOTAL_DEBE_SER_POSITIVO = "El valor total debe ser positivo";
    private static final String EL_TIPO_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_IGUAL_A = "El tipo identificacion debe tener una longitud igual a %s";
    
    private static final int LONGITUD_MINIMA_NUMERO_IDENTIFICACION = 6;
    private static final int LONGITUD_TIPO_IDENTIFICACION = 2;
    
    private Long id;
    private Long idVuelo;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private Integer pasajeros;
    private Integer valorTotal;
    private Boolean activa;
    private String token;
    private LocalDateTime fechaCreacion;
	public Reserva(Long id, Long idVuelo, String tipoIdentificacion, String numeroIdentificacion, Integer pasajeros, Integer valorTotal) {
		
		validarObligatorio(tipoIdentificacion, SE_DEBE_INGRESAR_EL_TIPO_IDENTIFICACION);
		validarObligatorio(numeroIdentificacion, SE_DEBE_INGRESAR_EL_NUMERO_IDENTIFICACION);
		validarPositivo(valorTotal, EL_VALOR_TOTAL_DEBE_SER_POSITIVO);
		validarIgual(tipoIdentificacion.length(), LONGITUD_TIPO_IDENTIFICACION, String.format(EL_TIPO_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_IGUAL_A,LONGITUD_TIPO_IDENTIFICACION));
		validarLongitudMinima(numeroIdentificacion, numeroIdentificacion.length(), String.format(EL_NUMERO_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A, LONGITUD_MINIMA_NUMERO_IDENTIFICACION));
		
		this.id = id;
		this.idVuelo = idVuelo;
		this.tipoIdentificacion = tipoIdentificacion;
		this.numeroIdentificacion = numeroIdentificacion;
		this.pasajeros = pasajeros;
		this.valorTotal = valorTotal;
		this.activa = true;
		this.token = UUID.randomUUID().toString();
		this.fechaCreacion = LocalDateTime.now();
	}
    
    


}
