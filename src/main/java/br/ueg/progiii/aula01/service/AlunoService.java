package br.ueg.progiii.aula01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.ueg.progiii.aula01.model.Aluno;
import br.ueg.progiii.aula01.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public Aluno incluir(Aluno aluno) {
		
		/*List<Aluno> alunos = alunoRepository.findByEmail(aluno.getEmail());
		if( ! CollectionUtils.isEmpty(alunos) ) {*/
		
		Boolean existeEmail = alunoRepository.exiteEmail(aluno.getEmail());
		if(existeEmail) {
		
			throw new IllegalStateException("Email: "+aluno.getEmail()+" já foi atribuido a outro aluno.");
		}
		
		Aluno alunoRetorno = alunoRepository.save(aluno);
		return alunoRetorno;
		
		
	}
	
	public List<Aluno> listar(){
		return alunoRepository.findAll();
	}
}
