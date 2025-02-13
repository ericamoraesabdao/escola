package com.example.escola.service;

import com.example.escola.dtos.AlunosDTO;
import com.example.escola.model.Alunos;
import com.example.escola.repository.AlunosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunosService {

    @Autowired
    private AlunosRepository alunosRepository;

    public List<AlunosDTO> listarAlunos() {
        List<Alunos> alunos = alunosRepository.findAll();

        return alunos.stream()
                .map(aluno -> new AlunosDTO(aluno.getId(), aluno.getNome(), aluno.getIdade()))
                .collect(Collectors.toList());
    }

    public AlunosDTO cadastrarAlunos(@Valid Alunos alunos) {

        alunosRepository.save(alunos);

        return new AlunosDTO(alunos.getId(), alunos.getNome(), alunos.getIdade());
    }
}
