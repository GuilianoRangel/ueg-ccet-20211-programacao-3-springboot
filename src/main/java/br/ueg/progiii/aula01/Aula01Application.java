package br.ueg.progiii.aula01;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ueg.progiii.aula01.model.Aluno;
import br.ueg.progiii.aula01.repository.AlunoRepository;

@SpringBootApplication
public class Aula01Application {

	public static void main(String[] args) {
		SpringApplication.run(Aula01Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AlunoRepository alunoRepository) {
		return args -> {
			Aluno aluno = new Aluno(null, "José", "Silva", "jose.silva@teste.com.br", 23);
			aluno  = alunoRepository.save(aluno);
			
			aluno.setIdade(25);
			
			/*
			 * aluno = alunoRepository.save(aluno);
			 * 
			 * alunoRepository.delete(aluno);
			 */
			Aluno aluno2 = new Aluno(null, "Tereza", "Silva", "tereza.silva@teste.com.br", 18);
			alunoRepository.save(aluno2);
			
			List<Aluno> alunos = alunoRepository.findByIdade(23);
			
			for(Aluno a: alunos) {
				System.out.println(a);
			}
		};
	}

}
