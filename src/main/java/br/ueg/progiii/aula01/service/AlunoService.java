package br.ueg.progiii.aula01.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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
	
	public Aluno getAluno(Long idAluno) {
		Optional<Aluno> aluno = obterAlunoSeExiste(idAluno);
		
		return aluno.get();
	}

	private Optional<Aluno> obterAlunoSeExiste(Long idAluno) {
		Optional<Aluno> aluno = alunoRepository.findById(idAluno);
		
		if(!aluno.isPresent()) {
			throw new IllegalStateException("Não existe Aluno com o ID:"+idAluno);
		}
		return aluno;
	}
	
	public List<Aluno> getAlunosByIdade(Integer idade){
		List<Aluno> alunos = alunoRepository.findByIdade(idade);
		if(CollectionUtils.isEmpty(alunos)) {
			throw new IllegalAccessError("Nenhum Aluno com a idade: "+idade+" encontrado");
		}
		return alunos;
	}

	public Aluno remover(Long idAluno) {
		Optional<Aluno> alunoOptional = obterAlunoSeExiste(idAluno);
		Aluno aluno = alunoOptional.get();
		alunoRepository.delete(aluno);		
		return aluno;
	}

	public Aluno alterar(Aluno aluno, Long idAluno) {
		Optional<Aluno> alunoOptional = obterAlunoSeExiste(idAluno);
		Aluno alunoBD = alunoOptional.get();
		
		if(StringUtils.hasLength(aluno.getPrimeiroNome())) {
			alunoBD.setPrimeiroNome(aluno.getPrimeiroNome());
		}
		
		if(StringUtils.hasLength(aluno.getSobreNome())) {
			alunoBD.setSobreNome(aluno.getSobreNome());
		}
		
		if(aluno.getIdade()!= null) {
			alunoBD.setIdade(aluno.getIdade());
		}
		
		alunoBD = alunoRepository.save(alunoBD);
				
		return alunoBD;
	}
}
