package com.ceiba.usuario.consulta;

import java.util.List;

import com.ceiba.usuario.puerto.dao.DaoAvion;

import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoAvion;


@Component
public class ManejadorListarAvion {

    private final DaoAvion daoAvion;

    public ManejadorListarAvion(DaoAvion daoAvion){
        this.daoAvion = daoAvion;
    }

    public List<DtoAvion> ejecutar(){ return this.daoAvion.listar(); }
}
