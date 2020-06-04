package com.rogerioopaiva.qualitySpeed.service.impl;

import com.rogerioopaiva.qualitySpeed.exception.RegraNegocioException;
import com.rogerioopaiva.qualitySpeed.model.entity.Colaborador;
import com.rogerioopaiva.qualitySpeed.model.repository.ColaboradorRepository;
import com.rogerioopaiva.qualitySpeed.service.ColaboradorService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class ColaboradorServiceImpl implements ColaboradorService {

    private ColaboradorRepository repository;


    public ColaboradorServiceImpl(ColaboradorRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Colaborador salvar(Colaborador colaborador) {
        return repository.save(colaborador);
    }

    @Override
    @Transactional
    public Colaborador atualizar(Colaborador colaborador) {
        Objects.requireNonNull(colaborador.getId());
        return repository.save(colaborador);
    }

    @Override
    public void deletar(Colaborador colaborador) {
        Objects.requireNonNull(colaborador.getId());
        repository.delete(colaborador);
    }

    @Override
    public List<Colaborador> buscar(Colaborador colaboradorFiltro) {
        Example example = Example.of( colaboradorFiltro,
                ExampleMatcher.matching()
                    .withIgnoreCase()
                    .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) );
        return repository.findAll(example);
    }

    @Override
    public void validar(Colaborador colaborador) {

        if(colaborador.getNomecolaborador() == null || colaborador.getNomecolaborador().trim().equals("")) {
            throw new RegraNegocioException("Informe o nome do colaborador.");
        }

        if(colaborador.getSetor() == null || colaborador.getSetor().trim().equals("")) {
            throw new RegraNegocioException("Informe o nome do setor.");
        }

        if (colaborador.getCargo() == null || colaborador.getCargo().trim().equals("")) {
            throw new RegraNegocioException("Informe o cargo.");
        }

        if (colaborador.getDataadmissao() == null || colaborador.getDataadmissao().toString().equals("")) {
            throw new RegraNegocioException("Informe a Data de Admissão.");
        }
    }

}
