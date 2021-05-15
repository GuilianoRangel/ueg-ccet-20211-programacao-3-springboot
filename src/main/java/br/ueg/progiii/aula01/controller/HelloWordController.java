package br.ueg.progiii.aula01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ueg.progiii.aula01.model.Aluno;

@RestController
public class HelloWordController {

	@PostMapping("/hello-world")
	public List<Aluno> listHelloWorldEndPoint() {
		List<Aluno> lista = new ArrayList<>();
//		lista.add(new Aluno(1, "José da silva", true));
//		lista.add(new Aluno(2, "Maria", true));
//		lista.add(new Aluno(3, "Tereza", true));
		return lista;
	}
	@GetMapping("/hello-world")
	public String getHelloWorld() {
		return "Hello World!!!";
	}
}
