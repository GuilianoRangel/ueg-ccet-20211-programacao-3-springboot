package br.ueg.progiii.aula01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ueg.progiii.aula01.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	List<Aluno> findByIdade(Integer idade);
	
	List<Aluno> findByEmail(String email);
	
	//JPQL
	@Query("" +
            "SELECT CASE WHEN COUNT(a) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Aluno a " +
            "WHERE a.email = ?1"
    )
	Boolean exiteEmail(String email);
}
