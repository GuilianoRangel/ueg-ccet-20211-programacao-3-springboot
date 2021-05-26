package br.ueg.progiii.aula01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Aluno")
@Table(
		name = "alunos",
		uniqueConstraints = {
			@UniqueConstraint(name="uk_amigo_email_unico", columnNames = "email")
		}
)
public @Data class Aluno {
	
	@Id
	@SequenceGenerator(
			name = "amigo_sequence",
			sequenceName = "amigo_sequence",
			allocationSize = 1,
			initialValue = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "amigo_sequence"
			)
	private Long id;
	
	@Column(name = "primeronome", nullable = false,	length = 200)
	private String primeiroNome;
		
	@Column(name = "sobronome", nullable = false, length = 150)
	private String sobreNome;
	
	@Column(name = "email", nullable = false, length = 250)
	private String email;
	
	@Column(name = "idade", nullable = false)
	private Integer idade;
}
