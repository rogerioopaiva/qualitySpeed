package com.rogerioopaiva.qualitySpeed.service;

import com.rogerioopaiva.qualitySpeed.model.entity.Colaborador;

import java.util.List;

public interface ColaboradorService {

    Colaborador salvar(Colaborador colaborador);

    Colaborador atualizar(Colaborador colaborador);

    void deletar(Colaborador colaborador);

    List<Colaborador> buscar( Colaborador colaboradorFiltro);

    void validar(Colaborador colaborador);
}
