package br.com.ojc.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ojc.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
