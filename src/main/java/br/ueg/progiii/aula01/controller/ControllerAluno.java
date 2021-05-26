package br.ueg.progiii.aula01.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping( path = "{idAluno}")
	public Aluno getAluno(@PathVariable("idAluno") Long idAluno) {
		return alunoService.getAluno(idAluno);
	}
	
	@GetMapping( path ="idade/{idade}")
	public List<Aluno> getAlunoByIdade(@PathVariable("idade") Integer idade){
		return alunoService.getAlunosByIdade(idade);
	}
	
	@PostMapping
	public Aluno incluir(@RequestBody Aluno aluno) {
		return alunoService.incluir(aluno);
	}
	
	@DeleteMapping( path = "{idAluno}")
	public Aluno remover(@PathVariable("idAluno") Long idAluno) {
		return alunoService.remover(idAluno);
	}
	
	@PatchMapping( path = "{idAluno}")
	public Aluno alterar(@RequestBody Aluno aluno, @PathVariable("idAluno") Long idAluno) {
		return alunoService.alterar(aluno, idAluno);
	}
}
