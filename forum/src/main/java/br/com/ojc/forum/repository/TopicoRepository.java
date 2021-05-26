package br.com.ojc.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ojc.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	//Em casos que uma coluna tenha o nome igual a entidade+coluna basta separa a entidade da coluna com uma "_" 
	List<Topico> findByCursoNome(String nomeCurso);
	
}
