package br.com.ojc.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ojc.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nomeCurso);

}
