package com.example.escola.controller;

import com.example.escola.dtos.AlunosDTO;
import com.example.escola.model.Alunos;
import com.example.escola.repository.AlunosRepository;
import com.example.escola.service.AlunosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunosControllers {
    @Autowired
    private AlunosService alunosService;

    @GetMapping
    public List<AlunosDTO> listarAlunos() {
        return alunosService.listarAlunos();
    }

    @PostMapping
    public ResponseEntity<?> cadastrarAlunos(@Valid @RequestBody Alunos alunosDTO) {
        try {
            AlunosDTO novoAluno = alunosService.cadastrarAlunos(alunosDTO);
            return ResponseEntity.ok(novoAluno);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
