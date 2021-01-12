package com.ceiba.usuario.consulta;

import java.util.List;

import com.ceiba.usuario.puerto.dao.DaoDestino;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoDestino;

@Component
public class ManejadorListarDestino {

    private final DaoDestino daoDestino;

    public ManejadorListarDestino(DaoDestino daoDestino){
        this.daoDestino = daoDestino;
    }

    public List<DtoDestino> ejecutar(){ return this.daoDestino.listar(); }
}
