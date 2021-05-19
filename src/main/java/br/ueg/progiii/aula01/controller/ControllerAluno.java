package br.ueg.progiii.aula01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ueg.progiii.aula01.model.Aluno;
import br.ueg.progiii.aula01.service.AlunoService;

@RestController
@RequestMapping( path = "api/v1/aluno" )
public class ControllerAluno {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping()
	public List<Aluno> listarTodos(){
		return alunoService.listar();
	}
	
	@PostMapping
	public Aluno incluir(@RequestBody Aluno aluno) {
		return alunoService.incluir(aluno);
	}
}
